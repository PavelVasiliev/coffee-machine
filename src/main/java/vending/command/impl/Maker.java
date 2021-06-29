package vending.command.impl;

import vending.command.Command;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.VendingMachine;
import vending.my_enum.VendingAction;

import java.util.Set;

public class Maker implements Command {
    private final VendingMachine machine;
    private final Command checker;

    public Maker(VendingMachine machine, Command checker) {
        this.machine = machine;
        this.checker = checker;
    }

    @Override
    public boolean execute(Coffee coffee) {
        if (checker.execute(coffee)) {
            int price = new Counter(machine).countPrice(coffee);
            machine.getStorage().money(VendingAction.TAKE_MONEY, price);
            makeCoffee(machine, coffee);
            System.out.printf("Price is %d\n", price);
            return true;
        }
        return false;
    }

    private void makeCoffee(VendingMachine machine, Coffee coffee) {
        System.out.printf("Making %s\n", coffee.getName().toLowerCase());

        Set<Ingredient> ingredientsForCoffee = coffee.getIngredients();
        for (Ingredient ingredientInMachine : machine.getStorage().getStorageInfo()) {
            for (Ingredient ingredient : ingredientsForCoffee) {
                if (ingredientInMachine.equals(ingredient)) {
                    ingredientInMachine.use(ingredient.getAmount());
                }
            }
        }
    }

    @Override
    public boolean execute(Ingredient ingredient, int newPrice) {
        System.out.println(this + "Cant do anything");
        return false;
    }

    @Override
    public int countPrice(Coffee coffee) {
        return -1;
    }
}
