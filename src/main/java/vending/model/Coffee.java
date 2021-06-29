package vending.model;

import lombok.AllArgsConstructor;
import vending.my_enum.CoffeeType;
import vending.my_enum.IngredientName;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class Coffee {
    private CoffeeType coffeeType;
    private Set<Ingredient> ingredients;

    public Coffee(CoffeeType coffeeType) {
        ingredients = new HashSet<>();
        ingredients.add(new Ingredient(IngredientName.CUP, 1));
        this.coffeeType = coffeeType;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return coffeeType.name();
    }

    public Coffee put(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this;
    }
}
