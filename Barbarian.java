public class Barbarian extends Protagonist {
    public static String about(){
        String description = "Barbarians cometh yonder and carry with them blessings of high defense.";
        return description;
    }

    public Barbarian(){
        health = 100;
        strength = 40;
        defense = 40;
        atkRate = 1.1;
    }

    public Barbarian( String nameInp) {
        this();
        name = nameInp;
    }
}
