import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Introduceti primul numar de minim 15 cifre ");
        BigInteger x = new Operations().input();
        while (x.toString().length() < 15) {
            System.out.print("Numarul introdus nu are 15 cifre, va rugam introduceti un nou numar: ");
            x = new Operations().input();
        }
        System.out.print("Introduceti al doilea numar de minim 15 cifre: ");
        BigInteger y = new Operations().input();
        while (y.toString().length() < 15) {
            System.out.print("Numarul introdus nu are 15 cifre, va rugam introduceti un nou numar: ");
            y = new Operations().input();
        }

        System.out.println("Introduceti operatia dorita: \n  --1-- ADUNARE\n  --2-- SCADERE\n  --3-- INMULTIRE\n  --4-- IMPARTIRE\n  --0-- EXIT");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        while (input != 0) {
            switch (input) {
                case 1:
                    System.out.println("Suma numerelor este: " + new Operations().addition(x, y));
                    break;
                case 2:
                    System.out.println("Diferenta numerelor este: " + new Operations().difference(x, y));
                    break;
                case 3:
                    System.out.println("Produsul numerelor este: " + new Operations().multiplication(x, y));
                    break;
                case 4:
                    System.out.println("Catul numerelor este: " + new Operations().division(x, y));
                    break;
                case 0:
                    break;
                default:
                    System.out.print("Operatie inexistenta, va rugam alegeti operatia dorita: ");
                    input = s.nextInt();
                    break;
            }
            System.out.println("Alegeti alta operatie sau \"0\" pentru iesire din program.");
            input = s.nextInt();
        }
    }
}
