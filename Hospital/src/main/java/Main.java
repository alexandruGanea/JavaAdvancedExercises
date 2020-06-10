import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //CERINTA
        // Sa se modeleze un spital
        // Dintr-un fisier se vor citi de pe fiecare rand numele, prenumele, sectia, tura (boolean), ale unui medic
        // Sa se separe medicii in 2 colectii: 1 in functie de specializare si 2 daca sunt de tura sau nu
        // Fiecare categorie din fiecare colectie sa fie scrisa intr-un fisier separat (5 fisiere)
        // Daca exista vreo categorie in functie de specializare care nu este de tura sa se arunce o exceptie NobodyOnShiftException
        // Dintr-un alt fisier se vor citi de pe fiecare rand numele, prenumele, varsta si specializarea pentru care a venit un pacient
        // Sa se separe pacientii intr-o colectie in functie de specializarea pentru care au venit.
        // Daca sunt mai mult de 5 pacienti la o specializare sa se arunce exceptia TooCrowdedException


        //INSTRUCTIUNI EXTRA
        // Pentru obiectele Pacient si Medic folosim mostenirea
        // Medicul va avea comportament specific specializarii, folosind interfete diferite pentru comportament (opereaza, ecografie, ortopedie)
        // Sa se puna teste unitare pentru fiecare comportament


        // PLAN
        // Avem nevoie de 10 fisiere.
        // Avem nevoie de 2 colectii Map ptr medici - pentru specializare (3 categorii: chirurg, radiolog, ortoped) si ptr tura (2 categorii: True/False)
        // Avem nevoie de o colectie Map ptr Pacienti - pe cele 3 specializari (chirurgie, radiologie, ortopedie)


        // INVENTAR
        // Clasa abstracta Person, cu atribute: nume, prenume, sectia
        // Clasa Medic - mostenim Person. Alte atribute: tura.
        // Clasa Patient - mostenim Person. Alte atribute: varsta.
        // Avem nevoie de 3 interfete: Opereaza, Ecografie, Ortopedie
        // Exceptii - creem 2 exceptii: NobodyOnShiftException si TooCrowdedException

        // Declaram toate fisierele ce le vom folosi
        String medicfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\MedicList.txt";
        String patientfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\PatientList.txt";
        String onShiftfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\OnShiftMedic.txt";
        String offShiftfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\OffShiftMedic.txt";
        String surgeryMfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\SurgeryMedic.txt";
        String surgeryPfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\SurgeryPatient.txt";
        String orthoMfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\OrthoMedic.txt";
        String orthoPfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\OrthoPatient.txt";
        String ultraMfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\EcoMedic.txt";
        String ultraPfp = "D:\\Java Projects\\Files for use in exercises\\Hospital\\EcoPatient.txt";

        // Declaram 3 Map-uri ptr specializarile medicilor
        Map<String, ArrayList<Medic>> medicSurgeryMap = new HashMap<String, ArrayList<Medic>>();
        Map<String, ArrayList<Medic>> medicOrthoMap = new HashMap<String, ArrayList<Medic>>();
        Map<String, ArrayList<Medic>> medicEcoMap = new HashMap<String, ArrayList<Medic>>();

        // Initializam cele 3 Map-uri, cu cheile corespunzatoare celor 3 specializari si ArrayList-uri goale care vor contine obiecte Medic
        medicSurgeryMap.put("Chirurgie", new ArrayList<Medic>());
        medicOrthoMap.put("Ortopedie", new ArrayList<Medic>());
        medicEcoMap.put("Ecografie", new ArrayList<Medic>());

        // Declaram 2 Map-uri ptr turele medicilor
        Map<Boolean, ArrayList<Medic>> onShiftMap = new HashMap<Boolean, ArrayList<Medic>>();
        Map<Boolean, ArrayList<Medic>> offShiftMap = new HashMap<Boolean, ArrayList<Medic>>();

        //Initializam cele 2 Map-uri cu cheile boolean de tura si ArrayList-uri goale ce vor contien obiecte Medic
        onShiftMap.put(true, new ArrayList<Medic>());
        offShiftMap.put(false, new ArrayList<Medic>());

        try {
            //FileReader + BufferedReader ptr medici si pacienti
            FileReader medicReader = new FileReader(medicfp);
            FileReader patientReader = new FileReader(patientfp);
            BufferedReader medicBuffered = new BufferedReader(medicReader);
            BufferedReader patientBuffered = new BufferedReader(patientReader);
            String mReadLine = medicBuffered.readLine();

            //Citim si procesam fisierul de medici
            while (mReadLine != null) {
                String[] medicLineArray = mReadLine.split(";");
                Medic medic = new Medic(medicLineArray[0], medicLineArray[1], medicLineArray[2], Boolean.valueOf(medicLineArray[3]));


                mReadLine = medicBuffered.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exceptie IO: " + e.getMessage());
        }


    }
}
