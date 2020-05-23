import Animals.*;
import Shapes.*;

public class Main {
    public static void main(String[] args) {


        //modelam forme
        Circle circle1 = new Circle();
        Rectangle rectangle1 = new Rectangle();
        Square square1 = new Square();

        System.out.println(circle1.draw());
        System.out.println(rectangle1.draw());
        System.out.println(square1.draw());

        System.out.println(circle1.perimeter());
        System.out.println(circle1.area());
        System.out.println(rectangle1.perimeter());
        System.out.println(rectangle1.area());
        System.out.println(square1.perimeter());
        System.out.println(square1.area());

        Shape circle2 = new Circle();
        Shape rectangle2 = new Rectangle();
        Shape square2 = new Square();

        System.out.println(circle2.draw());
        System.out.println(rectangle2.draw());
        System.out.println(square2.draw());

        Calculable circle3 = new Circle();
        Calculable rectangle3 = new Rectangle();
        Calculable square3 = new Square();

        System.out.println(circle3.perimeter());
        System.out.println(circle3.area());
        System.out.println(rectangle3.perimeter());
        System.out.println(rectangle3.area());
        System.out.println(square3.perimeter());
        System.out.println(square3.area());


        // modelam animale: zboara (porumbel), alearga(tigru), se tarasc(soparla), inoata(crocodil)
        Animal pidgeon1 = new Pidgeon();
        Animal tiger1 = new Tiger();
        Lizard lizard1 = new Lizard();
        Crocodile crocodile1 = new Crocodile();

        System.out.println(pidgeon1.move());
        System.out.println(pidgeon1.sleep());
        System.out.println(tiger1.move());
        System.out.println(tiger1.sleep());
        System.out.println(lizard1.move());
        System.out.println(lizard1.sleep());
        System.out.println(crocodile1.move());
        System.out.println(crocodile1.sleep());


        Pidgeon pidgeon2 = new Pidgeon();
        Tiger tiger2 = new Tiger();
        Lizard lizard2 = new Lizard();
        Crocodile crocodile2 = new Crocodile();

        System.out.println(pidgeon2.move());
        System.out.println(pidgeon2.sleep());
        System.out.println(tiger2.move());
        System.out.println(tiger2.sleep());
        System.out.println(lizard2.move());
        System.out.println(lizard2.sleep());
        System.out.println(crocodile2.move());
        System.out.println(crocodile2.sleep());

        System.out.println(pidgeon2.eat());
        System.out.println(tiger2.eat());
        System.out.println(lizard2.eat());
        System.out.println(crocodile2.eat());

        Carnivore crocodile3 = new Crocodile();
        Omnivore lizard3 = new Lizard();
        Herbivore pidgeon3 = new Pidgeon();
        Carnivore tiger3 = new Tiger();

        System.out.println(tiger3.eat());
        System.out.println(crocodile3.eat());
        System.out.println(lizard3.eat());
        System.out.println(pidgeon3.eat());

        Domestic pidgeon4 = new Pidgeon();
        Domestic lizard4 = new Lizard();
        Wild tiger4 = new Tiger();
        Wild crocodile4 = new Crocodile();

        System.out.println(pidgeon4.pet());
        System.out.println(crocodile4.pet());
        System.out.println(tiger4.pet());
        System.out.println(lizard4.pet());

        System.out.println(lizard1.pet());
        System.out.println(crocodile1.pet());


    }


}

