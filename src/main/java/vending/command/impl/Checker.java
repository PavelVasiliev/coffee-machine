package vending.command.impl;

import vending.command.Command;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.Storage;
import vending.model.VendingMachine;

import java.util.Map;
import java.util.Set;

public class Checker implements Command {
    private final VendingMachine machine;

    public Checker(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public boolean execute(Coffee coffee) {
        return checkIngredients(coffee);
    }

    @Override
    public boolean execute(Storage storage) {
        System.out.println(this + "Cant do anything");
        return false;
    }

    private boolean checkIngredients(Coffee coffee) {
        Map<Ingredient, Integer> ingredientsForCoffeeAmounts = coffee.getIngredients();
        Set<Ingredient> machineStore = machine.getStorage().getStorageInfo();
        for(Ingredient ingredientInStore: machineStore){
            for (Ingredient ingredientForCoffee : ingredientsForCoffeeAmounts.keySet()){
                if (ingredientInStore.equals(ingredientForCoffee)){
                    if (ingredientInStore.getAmount() <= ingredientsForCoffeeAmounts.get(ingredientForCoffee)){
                        System.out.printf("Not enough %s.\n", ingredientInStore.getName());
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
