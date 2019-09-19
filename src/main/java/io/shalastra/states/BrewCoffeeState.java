package io.shalastra.states;

import io.shalastra.models.Coffee;
import io.shalastra.models.CoffeeType;
import io.shalastra.services.CoffeeMachineService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class BrewCoffeeState implements State {

    private CoffeeType selectedCoffee;

    @Override
    public void nextState(CoffeeMachineService service) {
        Coffee coffee = service.getCoffeeMachine().getAvailableCoffees().get(this.selectedCoffee);

        service.setCurrentState(new ReduceState(coffee.getRecipe()));
    }

    @Override
    public void printStatus() {
        log.info("Your {} is ready to drink", selectedCoffee.name());
    }
}
