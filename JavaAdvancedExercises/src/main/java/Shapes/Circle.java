package Shapes;

public class Circle extends Shape implements Calculable{

    public String draw(){
        return "Desenez un cerc";
    }

    public String perimeter() {
        return "The length of a circle... ";
    }

    public String area() {
        return "The area of a circle is...";
    }
}
