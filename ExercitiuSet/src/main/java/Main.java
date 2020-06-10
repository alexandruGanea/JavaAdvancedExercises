import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Sa se citeasca dintr-un fisier info despre angajatii unei companii
        // avem nume,prenume,departament (IT si Vanzari)
        // Dupa ce i-am citit ii punem in 2 seturi: IT si Vanzari
        // afisam cele 2 seturi.

        Set<Employee> itSet = new HashSet<>();
        Set<Employee> salesSet = new HashSet<>();

        String employee = "D:\\Java Projects\\Files for use in exercises\\ExercitiuSet\\angajati.txt";
        try {
            FileReader fileReader = new FileReader(employee);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null) {
                String[] employeeInfoArray = text.split(",");
                Employee newEmployee = new Employee(employeeInfoArray[0], employeeInfoArray[1], employeeInfoArray[2]);
                if (newEmployee.getDepartment().equals("IT")) {
                    itSet.add(newEmployee);
                } else {
                    salesSet.add(newEmployee);
                }
                text = bufferedReader.readLine();
            }

            System.out.println("Lista angajati IT: ");
            for(Employee itEmployee: itSet){
                System.out.println(itEmployee);
            }
            System.out.println("Lista angajati Vanzari: ");
            for(Employee salesEmployee: salesSet){
                System.out.println((salesEmployee));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exceptie fisier negasit: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exceptie IO: " + e.getMessage());
        }
    }
}
