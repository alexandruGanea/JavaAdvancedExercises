package Animals;

public abstract class Animal {
    public abstract String move();

    public final String sleep(){
        return "The animal is sleeping";
    }
}
