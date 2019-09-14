package io.shalastra.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Coffee {

    private final String name;
    private final int requiredGrainsAmount;
    private final int requiredWaterAmount;

    private int requiredMilkAmount = 0;

    public Coffee(String name, int requiredGrainsAmount, int requiredWaterAmount) {
        this.name = name;
        this.requiredGrainsAmount = requiredGrainsAmount;
        this.requiredWaterAmount = requiredWaterAmount;
    }

    public Coffee(String name, int requiredGrainsAmount, int requiredWaterAmount, int requiredMilkAmount) {
        this(name, requiredGrainsAmount, requiredWaterAmount);
        this.requiredMilkAmount = requiredMilkAmount;
    }
}
