package vending.command;

import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.Storage;
import vending.model.VendingMachine;

import java.util.Map;

public interface Command {

    static double countPrice(VendingMachine machine, Coffee coffee){
        Map<Ingredient, Double> ingredientsPrice =  machine.getStorage().getIngredientsPrice();
        Map<Ingredient, Integer> ingredientsForCoffee = coffee.getIngredients();
        double result = 0;

        for(Ingredient i4Coffee : ingredientsForCoffee.keySet()){
            result += i4Coffee.getAmount() * ingredientsPrice.get(i4Coffee);
        }

        return result;
    }

    boolean execute(Coffee coffee);
    boolean execute(Storage storage);
}
