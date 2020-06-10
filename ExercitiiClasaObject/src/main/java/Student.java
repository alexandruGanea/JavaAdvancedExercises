public class Student {
    private String name;
    private String surname;
    private String adress;

    public Student(String name, String surname, String adress) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAdress() {
        return adress;
    }

    public String toString() {
        return this.name + " " + this.surname + ", " + this.adress;
    }

    public boolean equals(Student student) {
        return (this.name.equals(student.getName()) && this.surname.equals(student.getSurname()) && this.adress.equals(student.getAdress()));
    }


    }
}
