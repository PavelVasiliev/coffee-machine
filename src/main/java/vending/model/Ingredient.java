package vending.model;


import lombok.AllArgsConstructor;
import lombok.Setter;
import vending.my_enum.IngredientName;

import java.util.Objects;

@AllArgsConstructor
public class Ingredient {
    private IngredientName name;
    @Setter
    private int amount;
    private int price;


    public Ingredient(IngredientName name) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return (double) price/amount;
    }

    public IngredientName getName() {
        return name;
    }

    public void use(int amount) {
        this.amount -= amount;
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
