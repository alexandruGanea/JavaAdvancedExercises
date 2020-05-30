import java.awt.image.IndexColorModel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int x = 13;
        int y = 0;
        try {
            System.out.println("x/y = " + (x / y));
        } catch (ArithmeticException e) {
            System.out.println("Incercati o operatie aritmetica imposibila: " + e.getMessage());
        }


        int[] array = {1, 2, 3, 4, 5};
        try {
            System.out.println("Valoarea de pe pozitia 3 a array-ului este: " + array[3]);
            // System.out.println("Valoarea de pe pozitia 16 a array-ul este: " + array[16]);
            System.out.println("x/y din nou: " + (13 / 0));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("A aparut o exceptie IndexOutOfBounds: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceptie: " + e.getMessage());
        }

        String text = "a";
        if (text == null) {
            throw new NullPointerException("Ai uitat sa instantiezi textul");
        }

        try {
            System.out.println("Lungimea textului este: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("String-ul nu este instantiat: " + e.getMessage());
        }

        text = "Acesta este un text pentru tratat exceptia";
        try {
            System.out.println("Caracterul de la pozitia 8 este :" + charAtPosition(text));
        } catch (StringIndexOutOfBoundsException | OddNumberException e) {
            e.printStackTrace();
        }
        String text2 = "Test";
        try {
            System.out.println("Caracterul de la poz 8 este: " + charAtPosition(text2));
        } catch (StringIndexOutOfBoundsException | OddNumberException e) {
            System.out.println("Exceptie: String-ul nu are pozitia respectiva: " + e.getMessage());
        }

        // se introduce un numar de la tastatura
        // daca nr e par, afisam un mesaj
        // daca nr e impar, vrem sa aruncam exceptia OddNumberException

        try {
            insertNumber();

        } catch (OddNumberException e) {
            System.out.println("Nu ati introdus un numar par" + e.getMessage());
        }

        //punem utilizatorul sa introduca un cuvant
        // daca cuvantul incepe cu o vocala, aruncam exceptia si o prindem VowelException
        //daca incepe cu o consoana afisam "Totul e ok"

        try {
            checkForVowels();
        }catch(VowelException e){
            System.out.println("Exceptie: " + e.getMessage());
        }

    }


    public static char charAtPosition(String text1) throws OddNumberException {
        return text1.charAt(8);
    }

    public static void insertNumber() throws OddNumberException {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduceti un numar par de la tastatura: ");
        int input = s.nextInt();
        if (input % 2 == 0) {
            System.out.println("Felicitari, ati introdus nu numar par: " + input);
        } else {
            throw new OddNumberException("Numarul introdus nu este par");
        }
    }

    public static void checkForVowels() throws VowelException {
        System.out.print("Introduceti un cuvant de la tastatura: ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        if (input.startsWith("a") || input.startsWith("e") || input.startsWith("i") || input.startsWith("o") || input.startsWith("u")) {
            throw new VowelException(" Cuvantul incepe cu o vocala");
        } else {
            System.out.println("Totul e minunaaaat!");
        }
    }
}

