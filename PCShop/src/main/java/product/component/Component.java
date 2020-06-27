package product.component;

import product.Product;

public abstract class Component extends Product {

    protected String type;

    //de vazut ce fac cu type

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void upsell();
}
