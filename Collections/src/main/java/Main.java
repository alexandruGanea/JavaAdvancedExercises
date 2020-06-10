import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Proiect prin care exemplificam folosirea colectiilor.

        // Set
        // Sa se declare un se in care adaugam 10 din capitalelei Europei.

        Set<String> capitals = new HashSet<String>();

        // Adaugam 10 capitale folosind metoda add.

        capitals.add("Bucharest");
        capitals.add("Vinea");
        capitals.add("Madrid");
        capitals.add("Roma");
        capitals.add("Sofia");
        capitals.add("Budabest");
        capitals.add("Prague");
        capitals.add("Lisabona");
        capitals.add("London");
        capitals.add("Berlin");

        // Stergem o intrare folosinr remove()
        capitals.remove("London");

        // adaugam in set o intrare care deja exista
        capitals.add("Berlin");
        // Set nu poate contine duplicate, deci "Berlin" a fost adaugat o singura data.

        // parcurgerea unui set - for()
        for (String capital : capitals) {
            System.out.println("Capitala este: " + capital);
        }

        // LIST
        // Sa se adauge intr-o lista 10 culori
        List<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("green");
        colors.add("yellow");
        colors.add("orange");
        colors.add("brown");
        colors.add("green");

        for (String color : colors) {
            System.out.println("Culoarea este: " + color);
        }

        colors.remove("orange");
        for (String color : colors) {
            System.out.println("Culori, dupa stergere: " + color);
        }


        // LINKED LIST
        List<Integer> numbersLinkedList = new LinkedList<Integer>();
        numbersLinkedList.add(22);
        numbersLinkedList.add(66);
        numbersLinkedList.add(24);
        numbersLinkedList.add(1);
        for (Integer number : numbersLinkedList) {
            System.out.println("Numarul este: " + number);
        }
        numbersLinkedList.remove(Integer.valueOf(22));
        for (Integer number : numbersLinkedList) {
            System.out.println("Numarul, dupa stergere,  este: " + number);
        }

        // CLASA COLLECTIONS - Clasa din Java care ne ofera operatii cu colectii gata implementate (si optimizate)
        // Metodele din clasa Collections sunt statice

        //Vrem sa sortam listele

        Collections.sort(numbersLinkedList);
        System.out.println("Lista sortata: ");
        for (int number :
                numbersLinkedList) {
            System.out.println(number);
        }
        Collections.sort(colors);
        for (String color : colors) {
            System.out.println(color);
        }

        //CAUTARE - Collections.binarySearch( , ) - returneaza indezul/pozitia pe care a fost gasit elementul cautat,
        // rezultat negativ daca nu exista elementul cautat
        // lista trebuie ordonata crescator pentru a returna indexul cautat, atlfel nu este gasit
        int result = Collections.binarySearch(numbersLinkedList, 66);
        System.out.println("Rezultatul cautarii este " + result);

        int max = Collections.max(numbersLinkedList);
        int min = Collections.min(numbersLinkedList);

        System.out.println("Max: " + max + " " + "Min: " + min);


        //MAP
        // Sa se declare un Map in care sa se stocheze fiecare tara cu capitala ei (din Europa)

        Map<String, String> countryCapitalMap = new HashMap<String, String>();
        countryCapitalMap.put("Romania", "Bucharest");
        countryCapitalMap.put("Hungary", "Budapest");
        countryCapitalMap.put("Bulgaria", "Sofia");

        // Perechea key-value - putem sa luam din map valoarea in functie de cheie (daca o stim)
        System.out.println("Capitala Ungariei este " + countryCapitalMap.get("Hungary"));
        System.out.println("Capitala Bulgariei este " + countryCapitalMap.get("Bulgaria"));


        // Map care sa contina numele persoanelor si varstele lor

        Map<String, Integer> personAgeMap = new HashMap<String, Integer>();
        personAgeMap.put("Ionescu", 36);
        personAgeMap.put("Popescu", 25);

        System.out.println("Varsta lui Ionescu este " + personAgeMap.get("Ionescu"));

        // Parcurgem un Map
        Set<String> countryCapitalKeys = countryCapitalMap.keySet();
        for (String key : countryCapitalKeys) {
            System.out.println("Valoarea din map CountryCapitalMap aferenta cheii " + key + " este " + countryCapitalMap.get(key));
        }

        // Map<String, Object>
        // Map<String, List<String>>
    }


}


