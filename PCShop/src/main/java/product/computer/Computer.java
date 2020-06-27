package product.computer;

import product.Product;

public abstract class Computer extends Product {

    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
