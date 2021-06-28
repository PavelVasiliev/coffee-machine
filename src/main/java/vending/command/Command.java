package vending.command;

import vending.model.Coffee;
import vending.model.Ingredient;

public interface Command {

    boolean execute(Coffee coffee);

    boolean execute(Ingredient ingredient, int newPrice);

    int countPrice(Coffee coffee);
}
