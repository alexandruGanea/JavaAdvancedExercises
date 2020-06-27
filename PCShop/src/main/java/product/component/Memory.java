package product.component;

public class Memory extends Component{

    public Memory(String type, String name, int price, int quantity, boolean discount){
        this.type=type;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.discount=discount;
    }

    public Memory() {
    }
}
