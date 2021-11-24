public class Goblin extends Monster {
  public static String about(){
    String description = "Goblins art fast on their feet but slow in the noggin. What they lack in everything else,  they make up for in their high attack rate";
  	return description;
    }

  public Goblin(){
    health = 30;
    strength = 25;
    defense = 10;
    atkRate = 1.3;
		}


}
