package Shapes;

public class Square extends Shape implements Calculable {

    public String draw(){
        return "Desenez un patrat";
    }

    public String perimeter() {
        return "The perimeter of a square is...";
    }

    public String area() {
        return "The area of a square is...";
    }
}
