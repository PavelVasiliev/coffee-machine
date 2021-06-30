package vending.command.impl;

import vending.command.Command;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.Storage;
import vending.model.VendingMachine;

import java.util.Set;

public class Counter implements Command {
    private final VendingMachine machine;

    public Counter(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public int countPrice(Coffee coffee) {
        Storage storage = machine.getStorage();
        Set<Ingredient> ingredientsForCoffee = coffee.getIngredients();
        double cost = 0;
        for (Ingredient i4Coffee : ingredientsForCoffee) {
            Ingredient i = storage.get(i4Coffee);
            if (i != null) {
                cost += i4Coffee.getAmount() * i.getPrice();
            }
        }
        return (int)cost * 2; //100% extra charge
    }

    @Override
    public boolean execute(Coffee coffee) {
        System.out.println(this + "Cant do anything");
        return false;
    }

    @Override
    public boolean execute(Ingredient ingredient, int newPrice) {
        System.out.println(this + "Cant do anything");
        return false;
    }
}
