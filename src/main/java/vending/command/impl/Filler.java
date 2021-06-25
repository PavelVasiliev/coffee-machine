package vending.command.impl;

import vending.command.Command;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.Storage;
import vending.model.VendingMachine;

import java.util.Map;

public class Filler implements Command {

    private final VendingMachine machine;

    public Filler(VendingMachine machine) {
        this.machine = machine;
    }

    private void feelIngredients(Storage newArrival) {
        Map<Ingredient, Double> income = newArrival.getIngredientsPrice();
        Storage storage = machine.getStorage();
        income.forEach((ingredient, aDouble) -> storage.putInStorage(ingredient));
    }

    @Override
    public boolean execute(Storage newArrival) {
        feelIngredients(newArrival);
        return true;
    }

    @Override
    public boolean execute(Coffee coffee){
        System.out.println(this + "Cant do anything");
        return false;
    }
}
