public class Character{
    int health;
    int strength;
    int defense;
    double atkRate;
    
    public boolean isAlive(){
		return (health > 0);
	}
	
	public int getDefense(){
	    return defense;
	}
	
	public void lowerHP(int dmgDealt){
	    health -= dmgDealt;
	}
	
	public void attack (Character c){
	    int dmg = (int)((strength * atkRate) - c.defense);
	}
}
