import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {

    // sa se modeleze urmatoarele entitati
    // un student o sa aiba nume, prenume, nota la mate, nota la info si nota la fizica si un atribut "Admis la POLITEHNICA"
    // se vor introduce de la tastatura numele, prenumele si notele studentului
    // clasa parinte va fi Person
    // folosim o interfata ptr a gestiona notele si admiterea la facultate; admiterea se va calcula in functie de medii
    // daca media notelor este mai mica decat 6, sa se arunce exceptie BadGradesException


    // SA SE CREEZE SI SA SE TRATEZE EXCEPTIA ATUNCI CAND NOTELE NU SUNT INTRE 1 SI 10
    // SA SE MAI ADAUGE URMATORUL COMPORTAMENT, PRIN INTERMEDIUL UNEI INTERFETE:
    // SA SE CALCULEZE MEDIA DOAR LA MATE SI FIZICA SI SA SE ADAUGE UN CAMP "ADMIS LA FACULTATEA DE FIZICA"
    // SA SE CALCULEZE MEDIA DOAR LA MATE SI INFO SI SA SE ADAUGE CAMP "ADMIS LA FACULTATEA DE INFO"
    // SA SE MAI ADAUGE O EXCEPTIE ATUNCI CAND MEDIA ESTE 10 (PENTRU TOATE ADMITERILE) "FELICITARI, DEXTER!"
    // CEL PUTIN INCA O INTERFATA CU COMPORTAMENTE IMPLEMENTATE

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int reset = 0;
        System.out.println("Bine ati venit la Programul de Admitere la Facultate!");
        System.out.print("Introduceti prenumele studentului: ");
        String name = s.nextLine();
        System.out.print("Introduceti numele studentului: ");
        String surname = s.nextLine();
        System.out.println("Introduceti Facultatea dorita: \n --1-- Politehnica\n --2-- Facultatea de Fizica\n --3-- Facultatea de Informatica\n --0-- CANCEL");
        int choice = s.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    System.out.print("Introduceti nota la matematica: ");
                    int mathGrade = s.nextInt();
                    System.out.print("Introduceti nota la informatica: ");
                    int infoGrade = s.nextInt();
                    System.out.print("Introduceti nota la fizica: ");
                    int phisGrade = s.nextInt();
                    System.out.println("Student: " + name + " " + surname + "\nNote: Matematica: " + mathGrade + ", Informatica: " + infoGrade + ", Fizica: " + phisGrade);
                    Student student = new Student(name, surname, mathGrade, infoGrade, phisGrade);
                    try {
                        student.computePoliAverage();
                    } catch (BadGradesException |
                            WrongGradesException e) {
                        System.out.println("A fost o problema cu calcularea mediei: " + e.getMessage());
                    }
                    System.out.println("Rezultatul admiterii este: " + student.getAdmitted());
                    break;
                case 2:
                    System.out.print("Introduceti nota la matematica: ");
                    mathGrade = s.nextInt();
                    System.out.print("Introduceti nota la fizica: ");
                    phisGrade = s.nextInt();
                    System.out.println("Student: " + name + " " + surname + "\nNote: Matematica: " + mathGrade + ", Fizica: " + phisGrade);
                    infoGrade = 0;
                    student = new Student(name, surname, mathGrade, infoGrade, phisGrade);
                    try {
                        student.computePhisAverage();
                    } catch (BadGradesException |
                            WrongGradesException e) {
                        System.out.println("A fost o problema cu calcularea mediei: " + e.getMessage());
                    }
                    System.out.println("Rezultatul admiterii este: " + student.getAdmitted());
                    break;
                case 3:
                    System.out.print("Introduceti nota la matematica: ");
                    mathGrade = s.nextInt();
                    System.out.print("Introduceti nota la informatica: ");
                    infoGrade = s.nextInt();
                    System.out.println("Student: " + name + " " + surname + "\nNote: Matematica: " + mathGrade + ", Informatica: " + infoGrade);
                    phisGrade = 0;
                    student = new Student(name, surname, mathGrade, infoGrade, phisGrade);
                    try {
                        student.computeInfoAverage();
                    } catch (BadGradesException |
                            WrongGradesException e) {
                        System.out.println("A fost o problema cu calcularea mediei: " + e.getMessage());
                    }
                    System.out.println("Rezultatul admiterii este: " + student.getAdmitted());
                    break;
                default:
                    System.out.println("Nu ati introdus o optiune valida. \nIntroduceti Facultatea dorita: " +
                            "\n --1-- Politehnica\n --2-- Facultatea de Fizica\n --3-- Facultatea de Informatica \n --0-- CANCEL");
                    choice = s.nextInt();
                    break;
            }
            System.out.println("Doriti sa verificati admiterea la alta facultate?\n --1-- Politehnica\n --2-- Facultatea de Fizica\n --3-- Facultatea de Informatica \n --0-- INAPOI LA STUDENT\n --orice tasta-- EXIT");


            // Cum comparam studenti? Dupa media generala
            // Creem 2 studenti

            Student student_alex = new Student("Alex", "Matei", 8, 7, 9);
            Student student_liviu = new Student("Liviu", "Preda", 5, 7, 6);

            int averageAlex = (student_alex.getMathGrade() + student_alex.getInfoGrade() + student_alex.getPhisGrade()) / 3;
            int averageLiviu = (student_liviu.getMathGrade() + student_liviu.getPhisGrade() + student_liviu.getInfoGrade()) / 3;

            if (averageAlex > averageLiviu) {
                System.out.println("Media lui " + student_alex.name + "este mai mare decat media lui " + student_liviu.name);
            } else {
                System.out.println("Media lui " + student_alex.name + "este mai mica decat media lui " + student_liviu.name);
            }


            if (student_alex.getAverage() > student_liviu.getAverage()) {
                System.out.println("Media lui " + student_alex.name + "este mai mare decat media lui " + student_liviu.name);
            } else {
                System.out.println("Media lui " + student_alex.name + "este mai mica decat media lui " + student_liviu.name);
            }

            int comparatie = student_alex.compareTo(student_liviu);
            if(comparatie>0){
                System.out.println("Media lui " + student_alex.name + "este mai mare decat media lui " + student_liviu.name);
            }else if (comparatie<0){
                System.out.println("Media lui " + student_alex.name + "este mai mica decat media lui " + student_liviu.name);
            }else{
                System.out.println("Mediile celor 2 sunt egale");
            }

        }
    }
}