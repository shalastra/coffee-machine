package io.shalastra;

import io.shalastra.models.Coffee;
import io.shalastra.models.CoffeeType;
import io.shalastra.services.CoffeeMachineService;
import io.shalastra.states.BrewCoffeeState;
import io.shalastra.states.CheckWaterAmountState;
import io.shalastra.states.ReduceState;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CoffeeMachineServiceTest {

    @Test
    public void orderEspresso_shouldStepToReduceState() {
        CoffeeMachineService service = new CoffeeMachineService();

        service.setCurrentState(new BrewCoffeeState(CoffeeType.ESPRESSO));

        assertThat("check current state of coffee machine", service.getCurrentState(),
                instanceOf(BrewCoffeeState.class));

        service.nextState();

        assertThat("Check current state of coffee machine", service.getCurrentState(),
                instanceOf(ReduceState.class));
    }

    @Test
    public void orderEspresso_shouldReduceIngredients() {
        CoffeeMachineService service = new CoffeeMachineService();

        int grainsContainerLevel = service.getCoffeeMachine().getCoffeeDispenser().getCapacity();
        int waterContainerLevel = service.getCoffeeMachine().getWaterTank().getCapacity();
        int milkContainerLevel = service.getCoffeeMachine().getMilkTank().getCapacity();

        Coffee espresso = service.getCoffeeMachine().getAvailableCoffees().get(CoffeeType.ESPRESSO);

        int expectedWaterLevel = waterContainerLevel - espresso.getRecipe().getRequiredWaterAmount();
        int expectedGrainsLevel = grainsContainerLevel - espresso.getRecipe().getRequiredGrainsAmount();
        int expectedMilkLevel = milkContainerLevel - espresso.getRecipe().getRequiredMilkAmount();

        service.setCurrentState(new ReduceState(espresso.getRecipe()));
        service.nextState();

        assertEquals("Check water level after preparing the coffee", expectedWaterLevel,
                service.getCoffeeMachine().getWaterTank().getCurrentAmount());
        assertEquals("Check grains level after preparing the coffee", expectedGrainsLevel,
                service.getCoffeeMachine().getCoffeeDispenser().getCurrentAmount());
        assertEquals("Check milk level after preparing the coffee", expectedMilkLevel,
                service.getCoffeeMachine().getMilkTank().getCurrentAmount());
    }

    @Test
    public void makeWaterTankEmpty_shouldRefillContainer() {
        CoffeeMachineService service = new CoffeeMachineService();

        int waterContainerLevel = service.getCoffeeMachine().getWaterTank().getCapacity();
        int currentWaterLevel = service.getCoffeeMachine().getWaterTank().getCurrentAmount();

        assertEquals("Water levels should be equal to max capacity", waterContainerLevel, currentWaterLevel);

        // We have to order 3x Americano and 1x espresso to make container empty
        service.setCurrentState(new BrewCoffeeState(CoffeeType.AMERICANO));
        service.nextState();
        service.nextState();
        service.setCurrentState(new BrewCoffeeState(CoffeeType.AMERICANO));
        service.nextState();
        service.nextState();
        service.setCurrentState(new BrewCoffeeState(CoffeeType.AMERICANO));
        service.nextState();
        service.nextState();
        service.setCurrentState(new BrewCoffeeState(CoffeeType.ESPRESSO));
        service.nextState();
        service.nextState();

        int expectedWaterLevel = 0;
        currentWaterLevel = service.getCoffeeMachine().getWaterTank().getCurrentAmount();

        assertEquals("Water level should be equal to " + expectedWaterLevel, expectedWaterLevel, currentWaterLevel);

        service.setCurrentState(new CheckWaterAmountState());
        service.nextState();

        expectedWaterLevel = waterContainerLevel;
        currentWaterLevel = service.getCoffeeMachine().getWaterTank().getCurrentAmount();

        assertEquals("Water container should be full", expectedWaterLevel, currentWaterLevel);
    }
}
