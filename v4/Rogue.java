public class Rogue extends Protagonist {

    public Rogue(){
        health = 175;
        strength = 40;
        defense = 16;
        atkRate = 0.8;
    }

    public Rogue( String nameInp) {
        this();
        name = nameInp;
    }

    public static String about(){
        String description = "Rogues art sneaky bastards who art quick on their feet and haveth high stamina/health.";
        return description;
    }
}
