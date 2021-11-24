public class Monster extends Character {
	
  // char description: Monster has high defense and attack rate
  
  public Monster(){
    health = 150;
    strength = 25 + (int)(Math.random() * 25); // [25,50]
    defense = 20;
    atkRate = 1;    
  }

}
