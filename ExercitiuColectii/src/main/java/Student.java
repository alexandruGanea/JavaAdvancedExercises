public class Student {
    private String name;
    private String surname;
    private String studyClass;
    private String optional;

    public Student(String surname, String name, String studyClass, String optional) {
        this.surname = surname;
        this.name = name;
        this.studyClass = studyClass;
        this.optional = optional;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getStudyClass() {
        return studyClass;
    }

    public String getOptional() {
        return optional;
    }


    public String toString() {
        return this.surname + " " + this.name + ", Clasa a " + this.studyClass + "-a, Optional: " + this.optional;
    }
}

