package vending.model;

import vending.command.Command;
import vending.command.impl.Checker;
import vending.command.impl.Maker;
import vending.my_enum.VendingAction;


public class VendingMachine {
    private Storage storage;
    private int money = 0;

    public VendingMachine(Storage storage, int money) {
        this.storage = storage;
        this.money = money;
    }

    public Storage getStorage() {
        return storage;
    }
    public void make(Coffee coffee){
        new Maker(this, new Checker(this)).execute(coffee);
    }

    public void money(VendingAction action, double money) {
        switch (action) {
            case TAKE_MONEY:
                this.money += money;
            case GIVE_MONEY:
                this.money -= money;
        }
    }

    public void execute(boolean execute) {
    }

    public void info() {
        System.out.println("Money = " + money +
                "\nstorage = " + storage.getIngredientsPrice());
    }
}
