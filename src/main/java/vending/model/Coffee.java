package vending.model;

import lombok.AllArgsConstructor;
import vending.my_enum.CoffeeType;

import java.util.Map;

@AllArgsConstructor
public class Coffee {
    private CoffeeType coffeeType;
    private Map<Ingredient, Integer> ingredients;

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return coffeeType.name();
    }
}
