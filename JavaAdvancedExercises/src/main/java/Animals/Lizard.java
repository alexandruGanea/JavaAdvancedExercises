package Animals;

public class Lizard extends Animal implements Omnivore, Domestic{
    public String move(){
        return "The lizard crawls.";
    }
    public String eat() {
        return "The lizard eats both meat and plants";
    }

    public boolean pet() {
        return true;
    }
}
