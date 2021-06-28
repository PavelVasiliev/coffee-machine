package vending.model;

import lombok.AllArgsConstructor;
import vending.my_enum.CoffeeType;
import vending.my_enum.IngredientName;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Coffee {
    private CoffeeType coffeeType;
    private Map<Ingredient, Integer> ingredients;

    public Coffee(CoffeeType coffeeType) {
        ingredients = new HashMap<>();
        ingredients.put(new Ingredient(IngredientName.CUP), 1);
        this.coffeeType = coffeeType;
    }

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return coffeeType.name();
    }

    public void receipt(Ingredient ingredient, int amount) {
        ingredients.put(ingredient, amount);
    }
}
