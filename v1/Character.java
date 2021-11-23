public class Character{
    private int health;
    private int strength;
    private int defense;
    private double atkRate;
    
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
