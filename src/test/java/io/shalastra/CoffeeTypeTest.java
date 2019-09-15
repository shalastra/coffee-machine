package io.shalastra;

import io.shalastra.models.Coffee;
import io.shalastra.models.Recipe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeTypeTest {

    @Test
    public void createEspresso_shouldReturnEspressoCoffeeType() {
        String coffeeName = "espresso";
        Coffee espresso = new Coffee("espresso", new Recipe(10, 10));

        assertEquals("Coffee name should be equals", coffeeName, espresso.getName());
    }

    @Test
    public void createFlatWhite_shouldReturnFlatWhiteCoffeeType() {
        String coffeeName = "flat white";

        Coffee flatWhite = new Coffee("flat white", new Recipe(10, 10, 20));

        assertEquals("Coffee name should be equals", coffeeName, flatWhite.getName());
        assertEquals("Coffee required amount of milk should be equals", 10, flatWhite.getRecipe().getRequiredMilkAmount());
    }
}
