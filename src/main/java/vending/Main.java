package vending;

import vending.command.Command;
import vending.command.impl.Checker;
import vending.command.impl.Filler;
import vending.command.impl.Maker;
import vending.model.Coffee;
import vending.model.Ingredient;
import vending.model.Storage;
import vending.model.VendingMachine;
import vending.my_enum.CoffeeType;
import vending.my_enum.IngredientName;
import vending.my_enum.VendingAction;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Coffee> coffeeSet = createCoffeeSet();

        int money = 1_000;
        Ingredient coffeeBeans = new Ingredient(IngredientName.COFFEE_BEANS, 500);
        Ingredient watter = new Ingredient(IngredientName.WATTER, 5000);
        Ingredient milk = new Ingredient(IngredientName.MILK, 2500);
        Ingredient cup = new Ingredient(IngredientName.CUP, 100);

        VendingMachine machine = new VendingMachine(new Storage());

        Command filler = new Filler(machine);
        machine.execute(filler, coffeeBeans, 1200);
        machine.execute(filler, watter, 100);
        machine.execute(filler, milk, 200);
        machine.execute(filler, cup, 250);
        machine.getStorage().money(VendingAction.TAKE_MONEY, money);

        Command checker = new Checker(machine);
        Command maker = new Maker(machine, checker);
//        for(int i = 10; i > 0; i--){
//            machine.execute(maker, getRandomCoffee(coffeeSet));
//        }
        machine.info();
        coffeeBeans = new Ingredient(IngredientName.COFFEE_BEANS, 500);
        watter = new Ingredient(IngredientName.WATTER, 5000);
        milk = new Ingredient(IngredientName.MILK, 2500);
        cup = new Ingredient(IngredientName.CUP, 100);
        machine.execute(filler, coffeeBeans, 1200);
        machine.execute(filler, watter, 100);
        machine.execute(filler, milk, 200);
        machine.execute(filler, cup, 250);
//        for(int i = 10; i > 0; i--){
//            machine.execute(maker, getRandomCoffee(coffeeSet));
//        }
        machine.info();

        coffeeBeans = new Ingredient(IngredientName.COFFEE_BEANS, 500);
        watter = new Ingredient(IngredientName.WATTER, 5000);
        milk = new Ingredient(IngredientName.MILK, 2500);
        cup = new Ingredient(IngredientName.CUP, 100);
        machine.execute(filler, coffeeBeans, 1200);
        machine.execute(filler, watter, 100);
        machine.execute(filler, milk, 200);
        machine.execute(filler, cup, 250);
        machine.info();

        coffeeBeans = new Ingredient(IngredientName.COFFEE_BEANS, 500);
        watter = new Ingredient(IngredientName.WATTER, 5000);
        milk = new Ingredient(IngredientName.MILK, 2500);
        cup = new Ingredient(IngredientName.CUP, 100);
        machine.execute(filler, coffeeBeans, 1200);
        machine.execute(filler, watter, 100);
        machine.execute(filler, milk, 200);
        machine.execute(filler, cup, 250);
        machine.info();

    }

    static Set<Coffee> createCoffeeSet() {
        Set<Coffee> result = new HashSet<>();
        for(CoffeeType coffeeType : CoffeeType.values()){
            result.add(coffeeType.make(coffeeType));
        }

        return result;
    }
    static Coffee getRandomCoffee(Set<Coffee> set) {
        return set.stream().skip(new Random().nextInt(set.size())).findFirst().orElse(null);
    }
}
