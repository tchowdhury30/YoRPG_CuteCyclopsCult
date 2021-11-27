public class Paladin extends Protagonist {

    public Paladin() {
        health = 100;
        strength = 60;
        defense = 16;
        atkRate = 0.7;
    }

    public Paladin ( String nameInp ) {
        this();
        name = nameInp;
    }

    public static String about(){
        String description = "Paladins art knights of Ye Grand Order. They dost deal high damage to monsters.";
        return description;
    }

}
