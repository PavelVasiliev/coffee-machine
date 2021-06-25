package vending.command.impl;

import vending.command.Command;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.Storage;
import vending.model.VendingMachine;
import vending.my_enum.VendingAction;

import java.util.Map;

public class Maker implements Command {

    private final VendingMachine machine;
    private final Checker checker;

    public Maker(VendingMachine machine, Checker checker) {
        this.machine = machine;
        this.checker = checker;
    }

    @Override
    public boolean execute(Coffee coffee) {
        if (checker.execute(coffee)) {
            double price = Command.countPrice(machine, coffee);
            System.out.println("Price " + price);
            machine.money(VendingAction.TAKE_MONEY, price);
            makeCoffee(machine, coffee);
            System.out.printf("Making %s.\n", coffee.getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(Storage storage) {
        System.out.println(this + "Cant do anything");
        return false;
    }

    private void makeCoffee(VendingMachine machine, Coffee coffee) {
        Map<Ingredient, Integer> ingredientsForCoffee = coffee.getIngredients();
        for (Ingredient ingredientInMachine : machine.getStorage().getStorageInfo()) {
            for (Ingredient ingredient : ingredientsForCoffee.keySet()) {
                if (ingredientInMachine.equals(ingredient)) {
                    ingredientInMachine.use(ingredientsForCoffee.get(ingredient));
                }
            }
        }
    }
}
