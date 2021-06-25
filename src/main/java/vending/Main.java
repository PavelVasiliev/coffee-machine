package vending;

import vending.command.impl.Checker;
import vending.command.impl.Maker;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.Storage;
import vending.model.VendingMachine;
import vending.my_enum.CoffeeType;
import vending.my_enum.IngredientName;
import vending.my_enum.VendingAction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        int money = 1_000;
        Ingredient coffeeBeans = new Ingredient(IngredientName.COFFEE_BEANS, 500, 1_200); //half kilo
        Ingredient watter = new Ingredient(IngredientName.WATTER, 5000, 100); //five litters
        Ingredient milk = new Ingredient(IngredientName.MILK, 2500, 200); //two and half litters
        Ingredient cup = new Ingredient(IngredientName.CUP, 100, 250);

        Map<Ingredient, Double> storage = new HashMap<>();
        storage.put(coffeeBeans, coffeeBeans.getPrice());
        storage.put(watter, watter.getPrice());
        storage.put(milk, milk.getPrice());
        storage.put(cup, cup.getPrice());

        VendingMachine machine = new VendingMachine(new Storage(storage), money);
//        machine.money(VendingAction.TAKE_MONEY, money);

        Map<Ingredient, Integer> igr = new HashMap<>();
        igr.put(new Ingredient(IngredientName.COFFEE_BEANS), 12);
        igr.put(new Ingredient(IngredientName.WATTER), 200);
        igr.put(new Ingredient(IngredientName.MILK), 100);
        igr.put(new Ingredient(IngredientName.CUP), 1);
        Coffee cap = new Coffee(CoffeeType.CAPPUCCINO, igr);

        machine.info();
        System.out.println();
//        machine.execute(new Maker(machine, new Checker(machine)).execute(cap));

        machine.make(cap);
        machine.make(cap);
        machine.info();
    }

    private static Set<Coffee> createCoffeeSet() {
//        Set<Coffee> coffeeSet = Stream.of(
//                new Coffee(CoffeeType.CAPPUCCINO, Stream.of(
//                        new Ingredient(IngredientName.COFFEE_BEANS, 12), //half kilo
//                        new Ingredient(IngredientName.WATTER, 200), //five litters
//                        new Ingredient(IngredientName.MILK, 100), //two and half litters
//                        new Ingredient(IngredientName.CUP, 1)).collect(Collectors.toSet())),
//                new Coffee(CoffeeType.LATTE, Stream.of(
//                        new Ingredient(IngredientName.COFFEE_BEANS, 20), //half kilo
//                        new Ingredient(IngredientName.WATTER, 350), //five litters
//                        new Ingredient(IngredientName.MILK, 75), //two and half litters
//                        new Ingredient(IngredientName.CUP, 1)).collect(Collectors.toSet()))
//        ).collect(Collectors.toSet());
        return new HashSet<>();
    }
}
