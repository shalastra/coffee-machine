package io.shalastra.states;

import io.shalastra.services.CoffeeMachineService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckWaterAmountState extends CheckIngredientState implements State {

    @Override
    public void nextState(CoffeeMachineService service) {
        checkIngredientAmount(service.getCoffeeMachine().getWaterTank());
        service.setCurrentState(new CheckMilkAmountState());
    }

    @Override
    public void printStatus() {
        log.info("Checking amount of water...");
    }
}
