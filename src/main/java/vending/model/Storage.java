package vending.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import vending.my_enum.VendingAction;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class Storage {
    private Set<Ingredient> ingredients = new HashSet<>();
    private int money = 0;

    public Set<Ingredient> getStorageInfo() {
        return ingredients;
    }

    public void putInStorage(Ingredient newIngredient, int newPrice) {
        if(!ingredients.contains(newIngredient)){
            newIngredient.calculatePrice(newPrice);
            ingredients.add(newIngredient);
        } else {
            Ingredient ingredient;
            for (Ingredient i : ingredients) {
                if (i.equals(newIngredient)) {
                    ingredient = i;
                    ingredient.replenish(newIngredient, newPrice);
                    break;
                }
            }
        }
    }

    public void money(VendingAction action, int money) {
        switch (action) {
            case TAKE_MONEY -> this.money += money;
            case GIVE_MONEY -> this.money -= money;
        }
    }

    public Ingredient get(Ingredient ingredient) {
        Set<Ingredient> set = ingredients.stream().filter(ingredient::equals).collect(Collectors.toSet());
        return set.stream().findFirst().orElse(new Ingredient());
    }
}
