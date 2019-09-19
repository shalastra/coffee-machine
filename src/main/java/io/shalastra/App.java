package io.shalastra;

import io.shalastra.services.CoffeeMachineService;
import io.shalastra.states.OffState;

public class App {
    public static void main(String[] args) {
        CoffeeMachineService coffeeMachine = new CoffeeMachineService();

        do {
            coffeeMachine.nextState();
            coffeeMachine.printStatus();
        } while (!(coffeeMachine.getCurrentState() instanceof OffState));
    }
}
