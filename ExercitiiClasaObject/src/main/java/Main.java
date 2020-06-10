public class Main {
    public static void main(String[] args) {


        Student student = new Student("Ion", "Vasilescu", "Galati");
        Student student2 = new Student("Gigi", "Berlogea", "Cuca");
        Student student3 = new Student("Gigi", "Berlogea", "Cuca");

        System.out.println("Studentul nostru este: " + student);
        System.out.println("Studentul 2 este: " + student2);

        if (student2.equals(student3)) {
            System.out.println("Sunt egali");
        } else {
            System.out.println("Nu sunt egali");
        }

        Car car1 = new Car("Fiat", "Punto", 5);
        Car car2 = new Car("Skoda", "Octavia", 5);
        Car car3 = new Car("Skoda", "Octavia", 5);

        System.out.println("Prima masina: " + car1);
        System.out.println("A doua masina: " + car2);

        if (car1.equals(car2)) {
            System.out.println("Masinile sunt la fel");
        } else {
            System.out.println("Masinile nu sunt la fel");
        }

        if (car2.equals(car3)) {
            System.out.println("Masinile sunt la fel");
        } else {
            System.out.println("Masinile nu sunt la fel");
        }
    }

}
