package vending.model;

import vending.command.Command;


public class VendingMachine {
    private final Storage storage;

    public VendingMachine(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void execute(Command command, Coffee coffee) {
        command.execute(coffee);
    }

    public void execute(Command command, Ingredient ingredient, int newPrice) {
        command.execute(ingredient, newPrice);
    }

    public void info() {
        System.out.println("Money = " + storage.getMoney() +
                "\nstorage = " + storage.getIngredients());
    }
}
