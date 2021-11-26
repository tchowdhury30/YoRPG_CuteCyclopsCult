public class Character{
   protected  int health;
   protected  int strength;
   protected  int defense;
   protected  double atkRate;
    
    public boolean isAlive(){
		return (health > 0);
	}
	
	public int getDefense(){
	    return defense;
	}
	
	public void lowerHP(int dmgDealt){
	    health -= dmgDealt;
	}
	
	public int attack (Character c){
	    int dmg = (int)((strength * atkRate) - c.defense);
	    if (dmg < 0 || Math.random() > atkRate){ //The character can miss landing a hit, depending on their atkRate
	        dmg = 0;
	    }
	    c.lowerHP(dmg);
	    return dmg;
	}
}
