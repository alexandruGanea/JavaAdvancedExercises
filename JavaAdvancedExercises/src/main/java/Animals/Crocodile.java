package Animals;

public class Crocodile extends Animal implements Carnivore, Wild{
    public String move(){
        return "The crocodile swims.";
    }

    public String eat() {
        return "The crocodile eats meat.";
    }

    public boolean pet() {
        return false;
    }
}
