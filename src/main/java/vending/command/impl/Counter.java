package vending.command.impl;

import vending.command.Command;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.Storage;
import vending.model.VendingMachine;

import java.util.Map;

public class Counter implements Command {
    private final VendingMachine machine;

    public Counter(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public int countPrice(Coffee coffee) {
        Storage storage = machine.getStorage();
        Map<Ingredient, Integer> ingredientsForCoffee = coffee.getIngredients();
        double result = 0;
        for (Ingredient i4Coffee : ingredientsForCoffee.keySet()) {
            Ingredient i = storage.get(i4Coffee);
            if (i != null) {
                result += ingredientsForCoffee.get(i4Coffee) * i.getPrice();
            }
        }

        return (int) result * 2; //100% extra charge
    }

    @Override
    public boolean execute(Coffee coffee) {
        return false;
    }

    @Override
    public boolean execute(Ingredient ingredient, int newPrice) {
        return false;
    }
}
