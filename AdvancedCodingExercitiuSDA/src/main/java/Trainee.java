import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Trainee extends Person {

    private boolean codingBackground;

    public Trainee(String surname, String name, int yearOfBirth, boolean codingBackground) {
        this.surname = surname;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.codingBackground = codingBackground;
    }

    public boolean getCodingBackground() {
        return codingBackground;
    }

    public String toString() {
        int currentYear = Year.now().getValue();

        return this.surname + " " + this.name + ", " +(currentYear- this.yearOfBirth) + " ani, experienta anterioara: " + this.codingBackground;
    }
}
