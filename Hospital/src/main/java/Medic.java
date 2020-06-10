public class Medic extends Person implements Surgery, Ultrasound, Orthopedics {

    private boolean onShift;

    public Medic(String surname, String name, String specialization, boolean onShift) {
        this.surname = surname;
        this.name = name;
        this.specialization = specialization;
        this.onShift = onShift;
    }

    public boolean isOnShift() {
        return onShift;
    }

    public String toString() {
        return this.surname + ";" + this.name + ";" + this.specialization + ";" + this.onShift;
    }

    public String surgery() {
        if (this.onShift) {
            return "Doctorul opereaza.";
        } else {
            return "Doctorul nu este in spital astazi";
        }
    }

    public String orthopedics() {
        if (this.onShift) {
            return "Doctorul pune un ghips.";
        } else {
            return "Doctorul nu este in spital astazi";
        }
    }

    public String ultrasound() {
        if (this.onShift) {
            return "Doctorul face o o ecografie.";
        } else {
            return "Doctorul nu este in spital astazi";
        }
    }
}
