package io.shalastra.models;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Container {

    private final IngredientType ingredientType;
    private final int capacity;

    private int currentAmount;

    public Container(IngredientType ingredientType, int capacity) {
        this.ingredientType = ingredientType;
        this.capacity = capacity;
        this.currentAmount = this.capacity;
    }

    public void reduceCurrentAmount(int amount) {
        this.currentAmount = this.currentAmount - amount;
    }

    public void refill() {
        this.currentAmount = this.capacity;
    }
}
