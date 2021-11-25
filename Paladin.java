public class Paladin extends Protagonist {

    public Paladin() {
        health = 100;
        strength = 50;
        defense = 16;
        atkRate = 1.2;
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
