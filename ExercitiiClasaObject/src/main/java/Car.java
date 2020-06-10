public class Car {

    private String make;
    private String model;
    private int doors;

    public Car(String make, String model, int doors) {
        this.make = make;
        this.model = model;
        this.doors = doors;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getDoors() {
        return doors;
    }

    public String toString() {
        return this.make + " " + this.model + ", " + this.doors + " usi";
    }

    public boolean equals(Car car) {
        return (this.make.equals(car.getMake()) && this.model.equals(car.getModel()) && this.doors == car.getDoors());

    }
}
