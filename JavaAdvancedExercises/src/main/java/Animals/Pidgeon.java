package Animals;

public class Pidgeon extends Animal implements Herbivore, Domestic{

    public String move(){
        return "The Pidgeon flies.";
    }


    public String eat() {
        return "The pidgeon eats plants";
    }

    public boolean pet() {
        return true;
    }
}
