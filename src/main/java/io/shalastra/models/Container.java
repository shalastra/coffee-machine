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

    public void setCurrentAmount(int amount) {
        int newAmount = this.currentAmount - amount;

        if (newAmount <= 0) {
            refill();
        } else {
            this.currentAmount = newAmount;
        }
    }

    private void refill() {
        log.info("Oh no!, {} container is almost empty, refilling...", this.ingredientType.name());
        this.currentAmount = this.capacity;
    }
}
