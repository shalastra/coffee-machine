package io.shalastra.states;

import io.shalastra.services.CoffeeMachineService;

public interface State {

    void nextState(CoffeeMachineService service);

    void printStatus();
}

