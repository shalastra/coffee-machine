package io.shalastra.states;

import io.shalastra.services.CoffeeMachineService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OffState implements State {

    @Override
    public void nextState(CoffeeMachineService service) {
        service.setCurrentState(new OnState());
    }

    @Override
    public void printStatus() {
        log.info("Coffee machine is turning off");
    }
}
