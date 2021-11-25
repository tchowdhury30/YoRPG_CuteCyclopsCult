public class Dragon extends Monster {
  public static String about(){
    String description = "Dragons are dangerous, ferocious creatures. Their high strength, health, and defense are hindered by their slow attack rate. ";
    return description;
    }

    public Dragon(){
      health = 200;
      strength = 50;
      defense = 50;
      atkRate = 0.4;
  }

}
