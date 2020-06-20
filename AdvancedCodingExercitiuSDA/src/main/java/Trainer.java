public class Trainer extends Person {

    private boolean isAuthorized;

    public Trainer(String surname, String name, int yearOfBirth, boolean isAuthorized) {
        this.surname = surname;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.isAuthorized = isAuthorized;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public String toString() {
        return this.name + " " + this.surname;
    }
}
