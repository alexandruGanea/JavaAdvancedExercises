package Animals;

public class Tiger extends Animal implements Carnivore, Wild{
    public String move(){
        return "The tiger runs.";
    }
    public String eat(){
        return "The tiger eats meat.";
    }

    public boolean pet() {
        return false;
    }
}
