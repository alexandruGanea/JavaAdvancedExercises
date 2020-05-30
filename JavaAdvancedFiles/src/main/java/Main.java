import java.io.*;

public class Main {

    //sa se citeasca fiecare rand dintr-un fisier
    // sa se afiseze nr de cuvinte dintr-un rand
    public static void main(String[] args) {
        try {
            // Declaram cale catre fisier
            String filePathToRead = "D:\\FisierDeCitit.txt";

            // incarcarea fisierului in memoria programului pentru a-l citi - se face co obiectul "FileReader"
            FileReader fileReader = new FileReader(filePathToRead);

            // Incepem citirea din fisier, linie cu linie. Obiectul folosit se numeste "BufferedReader"
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();

            // "while" ne ajuta sa parcurgem(in cazul de fata sa printam) intregul fisier, linie cu linie
            while (text != null) {
                System.out.println("Linia citita este: " + text);

                // impartim linia in array de cuvinte, in functie de spatii, apoi printam lungimea lui (adica nr total de cuvinte din linie)
                String[] textArray = text.split(" ");
                System.out.println("Nr de cuvinte din linie este: " + (textArray.length));

                //incrementam linia din fisier
                text = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("A aparut o exceptie IOException: " + e.getMessage());
        }

        //VREM SA SCRIEM INTR-UN FISIER

        try {
            // Declaram cale catre fisier
            String filePathToWrite = "D:\\FisierDeScris.txt";

            //incarcarea fisierului in memoria programului pentru a-l scrie - se face co obiectul "FileWriter"
            FileWriter fileWriter = new FileWriter(filePathToWrite);

            // Incepem SCRIEREA in fisier, linie cu linie. Obiectul folosit se numeste "BufferedWriter"
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String textToWrite = "Acesta este un text pe care il vom scrie in fisier";
            String textToWrite2 = "\nAcesta este al doilea rand de text.";
            bufferedWriter.write(textToWrite);
            bufferedWriter.newLine();
            bufferedWriter.write(textToWrite2);

            // Salvam textul scris in fisier cu ajutorul FLUSH si CLOSE
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("A aparut o exceptie IOException: " + e.getMessage());
        }
    }
}