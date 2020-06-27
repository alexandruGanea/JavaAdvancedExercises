package upsell;

import product.component.Component;
import product.computer.Computer;

public abstract class ComputerUpsell {

    protected Computer computer;
    protected Component upsellComponent;

    public ComputerUpsell(Computer computer, Component upsellComponent) {
        this.upsellComponent = upsellComponent;
        this.computer=computer;
    }

    public ComputerUpsell() {
    }

    public abstract void upsell();

}
