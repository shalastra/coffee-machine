package io.shalastra.states;

import io.shalastra.services.CoffeeMachineService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrepareMachineState implements State {

    @Override
    public void nextState(CoffeeMachineService service) {
        service.setCurrentState(new CheckGrainsAmountState());
    }

    @Override
    public void printStatus() {
        log.info("Preparing coffee machine components, please wait.");
    }
}