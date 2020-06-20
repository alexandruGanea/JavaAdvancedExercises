import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.*;

public class Main {

    /*
    Inventar:
    Clase: SDA abstracta, singleton (un set de grupe) Person (abstract) Trainer, Trainee, Group
    2 fisiere: Trainee, Grupa
    1 exceptie: MaximumNumberOfStudentsReached
    colectie Set ptr Trainee:
    */

    public static void main(String[] args) {

        String filepathTrainees1 = "D:\\Java Projects\\Files for use in exercises\\ExercitiuSDA\\TraineesG1.txt";
        String filepathTrainees2 = "D:\\Java Projects\\Files for use in exercises\\ExercitiuSDA\\TraineesG2.txt";
        String filepathTrainees3 = "D:\\Java Projects\\Files for use in exercises\\ExercitiuSDA\\TraineesG3.txt";
        String filepathGroups = "D:\\Java Projects\\Files for use in exercises\\ExercitiuSDA\\Grupe.txt";

        try {

            FileReader fileReaderTrainees1 = new FileReader(filepathTrainees1);
            FileReader fileReaderTrainees2 = new FileReader(filepathTrainees2);
            FileReader fileReaderTrainees3 = new FileReader(filepathTrainees3);
            FileReader fileReaderGroups = new FileReader(filepathGroups);

            BufferedReader bufferedReaderTrainees1 = new BufferedReader(fileReaderTrainees1);
            BufferedReader bufferedReaderTrainees2 = new BufferedReader(fileReaderTrainees2);
            BufferedReader bufferedReaderTrainees3 = new BufferedReader(fileReaderTrainees3);
            BufferedReader bufferedReaderGroups = new BufferedReader(fileReaderGroups);


            // Citire fisier studenti din grupa1
            Set<Trainee> traineesGroup1 = new HashSet<Trainee>();
            String text1 = bufferedReaderTrainees1.readLine();
            while (text1 != null) {
                String[] textArray = text1.split(";");
                Trainee trainee = new Trainee(textArray[0], textArray[1], Integer.valueOf(textArray[2]), Boolean.valueOf(textArray[3]));
                if (traineesGroup1.size() == 5) {
                    throw new MaximumNumberOfStudentsReached("Numarul stundentilor din grupa 1 este mai mare decat 5");
                } else {
                    traineesGroup1.add(trainee);
                }
                text1 = bufferedReaderTrainees1.readLine();
            }
            System.out.println("Studenti grupa 1:");
            for (Trainee trainee : traineesGroup1) {
                System.out.println(trainee.toString());
            }

            // Citire fisier studenti din grupa a 2-a
            Set<Trainee> traineesGroup2 = new HashSet<Trainee>();
            String text2 = bufferedReaderTrainees2.readLine();
            while (text2 != null) {
                String[] textArray = text2.split(";");
                Trainee trainee = new Trainee(textArray[0], textArray[1], Integer.valueOf(textArray[2]), Boolean.valueOf(textArray[3]));
                traineesGroup2.add(trainee);
                if (traineesGroup2.size() <= 5) {
                    text2 = bufferedReaderTrainees2.readLine();
                } else
                    throw new MaximumNumberOfStudentsReached("Numarul studentilor din grupa 2 este mai mare decat 5");
            }
            System.out.println("Studenti grupa 2:");
            for (Trainee trainee : traineesGroup2) {
                System.out.println(trainee.toString());
            }

            // Citire fisier studenti din grupa a 3-a
            Set<Trainee> traineesGroup3 = new HashSet<Trainee>();
            String text3 = bufferedReaderTrainees3.readLine();
            while (text3 != null) {
                String[] textArray = text3.split(";");
                Trainee trainee = new Trainee(textArray[0], textArray[1], Integer.valueOf(textArray[2]), Boolean.valueOf(textArray[3]));
                traineesGroup3.add(trainee);
                if (traineesGroup3.size() <= 5) {
                    text3 = bufferedReaderTrainees3.readLine();
                } else
                    throw new MaximumNumberOfStudentsReached("Numarul studentilor din grupa 3 este mai mare decat 5");
            }
            System.out.println("Studenti grupa 3:");
            for (Trainee trainee : traineesGroup3) {
                System.out.println(trainee.toString());
            }

            // Citire fisier grupe
            Set<Group> groups = new HashSet<Group>();
            String text4 = bufferedReaderGroups.readLine();
            while (text4 != null) {
                String[] textArray = text4.split(";");
                Trainer trainer = new Trainer(textArray[1], textArray[2], 1985, true);
                Group group = new Group(textArray[0], trainer);
                if (trainer.getName().equals("Alex")) {
                    group.setGroupTrainees(traineesGroup1);
                }
                if (trainer.getName().equals("Anghel")) {
                    group.setGroupTrainees(traineesGroup2);
                }
                if (trainer.getName().equals("Florentina")) {
                    group.setGroupTrainees(traineesGroup3);
                }
                groups.add(group);
                text4 = bufferedReaderGroups.readLine();
            }
            System.out.println("Afisam grupele:");
            for (Group group : groups) {
                System.out.println(group.toString());
            }

            SoftwareDevelopmentAcademy sda = SoftwareDevelopmentAcademy.getInstance();
            sda.setGroups(groups);

            // Afisarea grupelor cu numarul maxim de studenti
            Set<Group> allGroups = sda.getGroups();
            for (Group group : allGroups) {
                if (group.getGroupTrainees().size() == 5) {
                    System.out.println("Afisam grupa " + group);
                }
            }

            // Afisarea studentilor care au peste 25 de ani
            System.out.println("\nStudentii cu varsta pana in 25 de ani");
            for (Group group : allGroups) {
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (Year.now().getValue() - trainee.getYearOfBirth() < 25) {
                        System.out.println(trainee.toString());
                    }
                }
            }

            // Afisarea studentilor care au experienta anterioara de programare
            System.out.println("\nStudentii cu experienta anterioara in programare:");
            for (Group group : allGroups) {
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (trainee.getCodingBackground()) {
                        System.out.println(trainee.toString());
                    }
                }
            }

            // Afisare grupa cu cei mai multi studenti fara cunostinte de programare

            TreeMap<Integer, Group> noCodingTreeMap = new TreeMap<Integer, Group>();
            for (Group group : allGroups) {
                int counter = 0;
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (!trainee.getCodingBackground()) {
                        counter++;
                    }
                }
                noCodingTreeMap.put(counter, group);
            }
            System.out.println("\nGrupul cu cei mai multi studenti fara cunostinte de programare este: " + noCodingTreeMap.lastEntry().getValue());


        } catch (MaximumNumberOfStudentsReached e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("A aparut exceptie IO" + e.getMessage());
        }


    }
}
