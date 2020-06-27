package product.peripheral;

import product.Product;

public abstract class Peripheral extends Product {

    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
