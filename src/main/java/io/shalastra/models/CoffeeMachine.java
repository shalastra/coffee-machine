package io.shalastra.models;

import lombok.Getter;

import java.util.EnumMap;

@Getter
public class CoffeeMachine {

    private final EnumMap<CoffeeType, Coffee> availableCoffees = new EnumMap<CoffeeType, Coffee>(CoffeeType.class) {{
        put(CoffeeType.ESPRESSO, new Coffee("espresso", new Recipe(10, 10)));
        put(CoffeeType.LUNGO, new Coffee("lungo", new Recipe(10, 20)));
        put(CoffeeType.CAPPUCCINO, new Coffee("cappuccino", new Recipe(10, 20, 10)));
        put(CoffeeType.AMERICANO, new Coffee("americano", new Recipe(10, 30)));
        put(CoffeeType.FLAT_WHITE, new Coffee("flat white", new Recipe(10, 20, 20)));
        put(CoffeeType.LATTE, new Coffee("latte", new Recipe(10, 10, 20)));
    }};

    private Container waterTank;
    private Container coffeeDispenser;
    private Container milkTank;

    public CoffeeMachine() {
        this.waterTank = new Container(IngredientType.WATER, 100);
        this.coffeeDispenser = new Container(IngredientType.GRAINS, 100);
        this.milkTank = new Container(IngredientType.MILK, 100);
    }
}
