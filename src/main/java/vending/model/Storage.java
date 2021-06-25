package vending.model;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Storage {
    private Map<Ingredient, Double> ingredientsPrice;

    public Storage(Map<Ingredient, Double> ingredientsAmount) {
        this.ingredientsPrice = ingredientsAmount;
    }

    public Set<Ingredient> getStorageInfo() {
        return ingredientsPrice.keySet();
    }


    public void putInStorage(Ingredient ingredient) {
        if (ingredientsPrice.containsKey(ingredient)) {
            Iterator<Ingredient> iterator = ingredientsPrice.keySet().iterator();
            Ingredient i;
            while (iterator.hasNext()) {
                i = iterator.next();
                if (i.equals(ingredient)) {
                    i.setAmount(i.getAmount() + ingredient.getAmount());
                    double newPrice = recalculatePrice(ingredient, i.getAmount());
                    ingredientsPrice.put(i, newPrice);
                    break;
                }
            }
        } else {
            System.out.println("New ingredient - " + ingredient.getName());
        }
    }

    private double recalculatePrice(Ingredient ingredient, int amount) {
        return (ingredient.getPrice() + ingredientsPrice.get(ingredient)) / amount;
    }

    public Map<Ingredient, Double> getIngredientsPrice() {
        return ingredientsPrice;
    }
}
