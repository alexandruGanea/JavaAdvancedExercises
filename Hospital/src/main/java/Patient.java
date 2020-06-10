public class Patient extends Person implements Surgery, Ultrasound, Orthopedics {

    private String age;

    public Patient(String surname, String name, String age, String specialization){
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.specialization = specialization;
    }

    public String getAge() {
        return age;
    }

    public String toString(){
        return this.surname + ";" + this.name +";"+this.age+";"+this.specialization;
    }

    public String surgery() {
        return "Pacientul este in operatie.";
    }

    public String orthopedics() {
        return "Pacientului i se pune un ghips";
    }

    public String ultrasound() {
        return "Pacientul este supus unei ecografii.";
    }
}
