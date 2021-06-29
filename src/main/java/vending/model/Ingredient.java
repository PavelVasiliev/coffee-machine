package vending.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import vending.my_enum.IngredientName;

import java.util.Objects;

@Getter
@NoArgsConstructor
public class Ingredient {
    private IngredientName name;
    private int amount;
    private double price;

    public Ingredient(IngredientName name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Ingredient(IngredientName name) {
        this.name = name;
    }

    public void replenish(Ingredient ingredient, int newPrice) {
        int temp = (int) (price * amount + newPrice);
        this.amount = this.amount + ingredient.amount;
        temp = 100 * temp / amount;

        this.price = (double) temp / 100.;
    }

    public void calculatePrice(int price) {
        this.price = (double) price / amount;
    }

    public void use(int amount) {
        this.amount -= amount;
    }

    public IngredientName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name=" + name +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
