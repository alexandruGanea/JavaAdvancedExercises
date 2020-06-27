package product.peripheral;

public class Webcam extends Peripheral{

    public Webcam(String type, String name, int price, int quantity, boolean discount){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.discount=discount;
    }

    public Webcam() {
    }
}
