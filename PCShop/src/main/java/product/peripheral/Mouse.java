package product.peripheral;

public class Mouse extends Peripheral{

    public Mouse(String type, String name, int price, int quantity, boolean discount){
        this.type = type;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.discount=discount;
    }

    public Mouse() {
    }
}
