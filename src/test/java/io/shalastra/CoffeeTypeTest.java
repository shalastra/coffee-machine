package io.shalastra;

import io.shalastra.models.Coffee;
import io.shalastra.models.Recipe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeTypeTest {

    @Test
    public void createEspresso_shouldReturnEspressoCoffeeType() {
        String coffeeName = "espresso";
        Coffee espresso = new Coffee(coffeeName, new Recipe(10, 10));

        assertEquals("Coffee name should be equals", coffeeName, espresso.getName());
    }

    @Test
    public void createFlatWhite_shouldReturnFlatWhiteCoffeeType() {
        String coffeeName = "flat white";
        int milkAmount = 20;

        Coffee flatWhite = new Coffee(coffeeName, new Recipe(10, 10, milkAmount));

        assertEquals("Coffee name should be equals", coffeeName, flatWhite.getName());
        assertEquals("Coffee required amount of milk should be equals", milkAmount, flatWhite.getRecipe().getRequiredMilkAmount());
    }
}
