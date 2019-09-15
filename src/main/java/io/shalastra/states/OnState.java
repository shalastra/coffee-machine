package io.shalastra.states;

import io.shalastra.services.CoffeeMachineService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnState implements State {

    @Override
    public void nextState(CoffeeMachineService service) {
        service.setCurrentState(new PrepareMachineState());
    }

    @Override
    public void printStatus() {
        log.info("Coffee machine is turning on.");
    }
}
