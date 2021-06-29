package vending.my_enum;


import vending.model.Coffee;
import vending.model.Ingredient;

public enum CoffeeType {
    LATTE(20,350,100),
    CAPPUCCINO(12,200,100),
    RISTRETTO(7, 20, 0),
    ESPRESSO(16,250,0),
    AMERICANO(16, 150, 0);

    private final int coffeBeans;
    private final int water;
    private final int milk;

    CoffeeType(int coffeBeans, int water, int milk) {
        this.coffeBeans = coffeBeans;
        this.water = water;
        this.milk = milk;
    }

    public Coffee make(CoffeeType coffeeType){
        Ingredient coffeBeans = new Ingredient(IngredientName.COFFEE_BEANS, this.coffeBeans);
        Ingredient water = new Ingredient(IngredientName.WATTER, this.water);
        Ingredient milk = new Ingredient(IngredientName.MILK, this.milk);
        Ingredient cup = new Ingredient(IngredientName.CUP, 1);

        Coffee coffee = new Coffee(coffeeType);
        coffee.receipt(coffeBeans, coffeBeans.getAmount());
        coffee.receipt(water, water.getAmount());
        coffee.receipt(milk, milk.getAmount());
        coffee.receipt(cup, cup.getAmount());
        return coffee;
    }
}
