/**********************************************
 * class YoRPG -- Driver file for Ye Olde Role Playing Game.
 * Simulates monster encounters of a wandering adventurer.
 * Required classes: Protagonist, Monster
 *
 **********************************************/

import java.io.*;
import java.util.*;

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;
  private String protagClass;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    difficulty = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "\n Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    while(true){
    	try {
	    	name = in.readLine();
		if (name.length() != 0){
			break;
		}
		System.out.println("Art thou deaf? What ist thy name? \n");
    	} catch ( IOException e ) {}
    }

    s = "\n Well, " + name + ", do tell, what art thou? \n";
    s += "\t1: Paladin \n";
    s += "\t2: Barbarian \n";
    s += "\t3: Rogue \n";
    s += "\t4: I beg thee pardon? [info on each class] \n";
    s += "Choose wisely: ";
    System.out.println( s );

    while(true){
	    try {
		    protagClass = in.readLine();
    		//instantiate the player's character
    		if (protagClass.equals("1")){
        		pat = new Paladin( name );
			break;
    		}
    		else if (protagClass.equals("2")){
        		pat = new Barbarian( name );
			break;
    		}
    		else if (protagClass.equals("3")){
        		pat = new Rogue( name );
			break;
    		}
		else if (protagClass.equals("4")){
			System.out.println( "\n" + Paladin.about() + "\n"
					+ Rogue.about() + "\n"
					+ Barbarian.about() + "\n");
			System.out.println("Thy chooseth: ");
		}
    		else { // If the end user inputs anything else, it will get the peasant class
			System.out.println("\nYou egg! Fine, thou shalt be the peasant thou hast always been!\n");
        		pat = new Protagonist( "Peasant" ); //Name will automatically be changed to Peasant
			break;
    		}
    	    }
            catch ( IOException e ) {}
    }



  }//end newGame()


  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {
    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) ) {
	    System.out.println( "\nNothing to see here. Move along!" );
    } else {
	    String monsType;
      String desc;
	    Double spawner = Math.random();
	    if (spawner <= (0.05 * difficulty)) {
	        monsType = "Dragon";
          desc = Dragon.about();
	        smaug = new Dragon();
	    } else if (spawner <= (0.25 * difficulty)) {
	        monsType = "Timber Wolf";
	        smaug = new TimberWolf();
          desc = TimberWolf.about();
	    } else {
	        monsType = "Goblin";
	        smaug = new Goblin();
          desc = Goblin.about();
	    }
	    System.out.println("Lo, yonder " + monsType + " approacheth!\n" + desc);

	    while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye!" );
          i = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }

        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage.");
		    
	System.out.println( "\n" + "Thou health is now: " + pat.health);
	System.out.println( "And Ye Olde Monter's: " + smaug.health);
	    
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thy skull." );
        return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
        return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
	    }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...


    //loading...
    YoRPG game = new YoRPG();
    int encounters = 0;
    while( encounters < MAX_ENCOUNTERS ) {
    if ( !game.playTurn() )
    break;
    encounters++;
    System.out.println();
    }
    System.out.println( "Thy game doth be over." );

  }//end main

}//end class YoRPG
