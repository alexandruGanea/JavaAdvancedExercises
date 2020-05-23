public class Main {
    public static void main(String[] args) {


        int x = 13;
        int y = 0;
        try {
            System.out.println("x/y = " + (x / y));
        } catch (ArithmeticException e) {
            System.out.println("Incercatei o operatie aritmetica imposibila: " + e.getMessage());
        }
    }
}
