import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Sa se citeasca dintr-un fisier linie cu linie
        // Sa se scrie in alt fisier liniile din primul fisier care au numar par de cuvinte


        try {
            String fileToRead = "D:\\FisierDeCitit.txt";
            String fileToWrite = "D:\\FisierDeScris.txt";

            FileReader fileReader = new FileReader(fileToRead);
            FileWriter fileWriter = new FileWriter(fileToWrite);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String textLine = bufferedReader.readLine();
            while (textLine != null) {
                String[] textLineArray = textLine.split(" ");
                if (textLineArray.length % 2 == 0) {
                    bufferedWriter.write(textLine);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                textLine = bufferedReader.readLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Am prins IOException: " + e.getMessage());
        }
    }
}
