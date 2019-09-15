package io.shalastra.states;

import io.shalastra.models.Container;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CheckIngredientState {

    void checkIngredientAmount(Container container) {
        int currentAmount = container.getCurrentAmount();

        if (currentAmount <= 0) {
            log.info("Oh no!, {} container is almost empty, refilling...", container.getIngredientType().name());
            container.refill();
        }
    }
}
