public class Peasant extends Protagonist {

    public Paladin() {
        health = 100;
        strength = 20;
        defense = 10;
        atkRate = 0.9;
    }

    public Peasant ( String nameInp ) {
        this();
        name = nameInp;
    }

    public static String about(){
        String description = "Peasants are hard workers who fate has been cruel too. They possess neither literacy, strength, or defense. But their stubborness has gifted them with a high atack rate.";
        return description;
    }

}
