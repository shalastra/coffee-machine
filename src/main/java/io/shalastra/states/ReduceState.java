package io.shalastra.states;

import io.shalastra.models.CoffeeMachine;
import io.shalastra.models.Recipe;
import io.shalastra.services.CoffeeMachineService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ReduceState implements State {

    private Recipe recipe;

    @Override
    public void nextState(CoffeeMachineService service) {
        reduce(service.getCoffeeMachine(), recipe);
        service.setCurrentState(new CheckGrainsAmountState());
    }

    private void reduce(CoffeeMachine coffeeMachine, Recipe recipe) {
        coffeeMachine.getWaterTank().reduceCurrentAmount(recipe.getRequiredWaterAmount());
        coffeeMachine.getCoffeeDispenser().reduceCurrentAmount(recipe.getRequiredGrainsAmount());
        coffeeMachine.getMilkTank().reduceCurrentAmount(recipe.getRequiredMilkAmount());
    }

    @Override
    public void printStatus() {
        log.info("Amounts of all ingredients are decreasing.");
    }
}
