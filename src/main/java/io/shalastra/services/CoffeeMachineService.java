package io.shalastra.services;

import io.shalastra.models.CoffeeMachine;
import io.shalastra.states.OffState;
import io.shalastra.states.State;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeeMachineService {

    @Getter
    private final CoffeeMachine coffeeMachine;

    @Setter
    @Getter
    private State currentState;

    public CoffeeMachineService() {
        this.coffeeMachine = new CoffeeMachine();
        this.currentState = new OffState();
    }

    public void nextState() {
        currentState.nextState(this);
    }

    public void printStatus() {
        currentState.printStatus();
    }
}
