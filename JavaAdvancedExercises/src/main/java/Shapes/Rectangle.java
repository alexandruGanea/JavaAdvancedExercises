package Shapes;

public class Rectangle extends Shape implements Calculable{

    public String draw(){
        return "Desenez un dreptunghi";
    }

    public String perimeter() {
        return "The perimeter of a rectangle is... ";
    }

    public String area() {
        return "The area of a rectangle is...";
    }
}
