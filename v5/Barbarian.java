public class Barbarian extends Protagonist {

    public Barbarian(){
        health = 100;
        strength = 40;
        defense = 50;
        atkRate = 0.7;
    }

    public Barbarian( String nameInp) {
        this();
        name = nameInp;
    }

    public static String about(){
        String description = "Barbarians cometh yonder and carry with them blessings of high defense.";
        return description;
    }
}
