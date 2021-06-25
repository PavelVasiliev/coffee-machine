package vending.my_enum;

public enum IngredientName {
    COFFEE_BEANS("Кофейные зерна"),
    WATTER("Вода"),
    MILK("Молоко"),
    CUP("Стакан");

    private String name;
    IngredientName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
