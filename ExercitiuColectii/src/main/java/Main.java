import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Sa se citeasca dintr-un fisier de pe fiecare rand numele, prenumele, clasa, optional (atribute separate prin ";")
        // Sa se grupeze in colectii diferite elevii in functie de clasa in care fac parte si in functie de optionalul la care participa

        String filePath = "D:\\Java Projects\\Files for use in exercises\\ExercitiuColectii\\fisierElevi.txt";

        try {

            // Citim fisierul
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String read = bufferedReader.readLine();

            //Am creat Map-uri cu toti studentii, cu cheie an de studiu si optional
            Map<String, ArrayList<Student>> classMap = new HashMap<>();
            Map<String, ArrayList<Student>> optionalsMap = new HashMap<String, ArrayList<Student>>();

            // Pregatim Map-uri (le declaram cheia) in functie de anul de studiu si material optionala
            // Creem arrayList-uri goale, pentru a putea fi umplute ulterior cu studentii care au anul de studiu, respectiv optionalul ales
            classMap.put("9", new ArrayList<Student>());
            classMap.put("10", new ArrayList<Student>());
            classMap.put("11", new ArrayList<Student>());
            classMap.put("12", new ArrayList<Student>());

            optionalsMap.put("Informatica", new ArrayList<Student>());
            optionalsMap.put("Germana", new ArrayList<Student>());
            optionalsMap.put("MatematicaAplicata", new ArrayList<Student>());

            while (read != null) {

                // Cat timp nu e linia din fisier goala impartim linia in array de String-uri separate de ":"
                String[] readArray = read.split(";");

                // Instantiem obiecte de tip Student cu elementele array-ului creat anterior
                Student student = new Student(readArray[0], readArray[1], readArray[2], readArray[3]);

                // Aici grupam studentii in functie de clasa si ii adaugam cu SWITCH in classMap
                switch (student.getStudyClass()) {
                    case "9":
                        classMap.get("9").add(student);
                        break;
                    case "10":
                        classMap.get("10").add(student);
                        break;
                    case "11":
                        classMap.get("11").add(student);
                        break;
                    case "12":
                        classMap.get("12").add(student);
                        break;
                    default:
                        break;
                }

                //Aici grupam studentii in functie de optional si ii adaugam cu IF in optionalsMap
                if (student.getOptional().equals("Informatica")) {
                    optionalsMap.get("Informatica").add(student);
                } else if (student.getOptional().equals("MatematicaAplicata")) {
                    optionalsMap.get("MatematicaAplicata").add(student);
                } else if (student.getOptional().equals("Germana")) {
                    optionalsMap.get("Germana").add(student);
                }

                read = bufferedReader.readLine();
            }

            //Afisam toti elevii de la Informatica
            System.out.println("Elevii de la informatica sunt: ");
            ArrayList<Student> infoStudentsArrayList = optionalsMap.get("Informatica");
            for(Student student: infoStudentsArrayList){
                System.out.println(student);
            }

            //Afisam toti elevii de clasa a 11-a
            System.out.println("Elevii de clasa a 11-a sunt: ");
            ArrayList<Student> students11thGradeArrayList = classMap.get("11");
            for(Student student: students11thGradeArrayList){
                System.out.println(student);
            }

            // Afisam toti elevii de la MatematicaAdaptata
            System.out.println("Elevii de la MatematicaAdaptata sunt: ");
            ArrayList<Student> mathStudentsArrayList = optionalsMap.get("MatematicaAplicata");
            for(Student student: mathStudentsArrayList){
                System.out.println(student);
            }
            // Afisam toti elevii de clasa a 10-a
            System.out.println("Elevii de clasa a 10-a sunt: ");
            ArrayList<Student> students10thGradeArrayList = classMap.get("10");
            for(Student student: students10thGradeArrayList){
                System.out.println(student);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exceptie IO: " + e.getMessage());
        }

    }
}
