package vending.command.impl;

import vending.command.Command;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.VendingMachine;

public class Filler implements Command {
    private final VendingMachine machine;

    public Filler(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public boolean execute(Ingredient ingredient, int newPrice) {
        machine.getStorage().putInStorage(ingredient, newPrice);
        return true;
    }

    @Override
    public int countPrice(Coffee coffee) {
        return -1;
    }

    @Override
    public boolean execute(Coffee coffee) {
        System.out.println(this + "Cant do anything");
        return false;
    }
}
