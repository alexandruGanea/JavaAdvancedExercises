import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Sa se citeasca dintr-un fisier
        // Pe primul rand avem un sir de numere separate prin ";"
        // Sa se ordoneze numerele
        // Sa se afiseze in ordinea inversa
        // Sa se caute numarul 325
        // Sa se afiseze cel mai mare numar
        // Sa se afiseze cel mai mic numar
        // Sa se afiseze lista de numere fara duplicate


        String filePath = "D:\\Java Projects\\Files for use in exercises\\ExercitiuListe\\numbersToRead.txt";
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String read = bufferedReader.readLine();
            String[] numbersArray = read.split(";");
            List<Integer> numbersList = new ArrayList<>();
            for (String element : numbersArray) {
                numbersList.add(Integer.valueOf(element));
            }
            Collections.sort(numbersList);
            System.out.print("Afisam elemente ordonate crescator: ");
            for (Integer number : numbersList) {
                System.out.print(number + " ");
            }

            Collections.reverse(numbersList);
            System.out.print("\nAfisam elemente ordonate descrescator: ");
            for (Integer number : numbersList) {
                System.out.print(number + " ");
            }

            Collections.sort(numbersList);
            int position = Collections.binarySearch(numbersList, Integer.valueOf(325));
            if (position < 1) {
                System.out.println("\nElementul nu a fost gasit");
            } else {
                System.out.println("\nIndexul elementului 325 este: " + position);
            }

            System.out.println("Cel mai mare numar este: " + Collections.max(numbersList));
            System.out.println("Cel mai mic numar este: " + Collections.min(numbersList));

            Set<Integer> numbersSet = new HashSet<>();
            System.out.print("Setul fara elemente duplicate este: ");
            for(Integer number: numbersList){
                numbersSet.add(number);
                System.out.print(number + " ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exceptie IO: " + e.getMessage());
        }
    }
}
