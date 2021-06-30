package vending.command.impl;

import vending.command.Command;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.VendingMachine;

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

    private boolean checkIngredients(Coffee coffee) {
        Set<Ingredient> ingredientsForCoffeeAmounts = coffee.getIngredients();
        Set<Ingredient> machineStore = machine.getStorage().getStorageInfo();
        boolean result = ingredientsForCoffeeAmounts.stream()
                .noneMatch(ingredientForCoffee -> machineStore.stream()
                        .anyMatch(ingredientInStore -> ingredientInStore.equals(ingredientForCoffee)
                                & ingredientInStore.getAmount() < ingredientForCoffee.getAmount()));
        if(!result){
            System.out.println("Not enough ingredients");
        }
        return result;
    }

    @Override
    public boolean execute(Ingredient ingredient, int newPrice) {
        System.out.println(this + "Cant do anything");
        return false;
    }

    @Override
    public int countPrice(Coffee coffee) {
        System.out.println(this + "Cant do anything");
        return -1;
    }
}
