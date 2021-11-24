public class Protagonist extends Character {
  
  // char description: Protag can miss hits and has a lower defense, but the ability to make its strength double
  
  private String name;
  
  public Protagonist() {
    health = 100;
    strength = 40;
    defense = 16;
    atkRate = 0.6;
  }
  
  public Protagonist( String nameInp) {
    this(); 
    name = nameInp;
  }
  
  public void specialize() {
    strength = 80;
    defense = 8;
  }
  
  public void normalize(){
    strength = 40;
    defense = 16;
  }
  
  public String getName(){
    return name;
  }

}
