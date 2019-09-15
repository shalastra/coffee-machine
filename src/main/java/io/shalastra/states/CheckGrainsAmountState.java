package io.shalastra.states;

import io.shalastra.services.CoffeeMachineService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckGrainsAmountState extends CheckIngredientState implements State {

    @Override
    public void nextState(CoffeeMachineService service) {
        checkIngredientAmount(service.getCoffeeMachine().getCoffeeDispenser());
        service.setCurrentState(new CheckWaterAmountState());
    }

    @Override
    public void printStatus() {
        log.info("Checking amount of grains...");
    }
}
