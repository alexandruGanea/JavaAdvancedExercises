package product.computer;

public class Laptop extends Computer {

    public Laptop(String type, String name, int price, int quantity, boolean discount) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount=discount;
    }

    public Laptop() {
    }
}
