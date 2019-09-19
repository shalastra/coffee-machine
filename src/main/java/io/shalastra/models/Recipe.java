package io.shalastra.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Recipe {

    private final int requiredGrainsAmount;
    private final int requiredWaterAmount;

    private int requiredMilkAmount = 0;

    public Recipe(int requiredGrainsAmount, int requiredWaterAmount) {
        this.requiredGrainsAmount = requiredGrainsAmount;
        this.requiredWaterAmount = requiredWaterAmount;
    }

    public Recipe(int requiredGrainsAmount, int requiredWaterAmount, int requiredMilkAmount) {
        this(requiredGrainsAmount, requiredWaterAmount);
        this.requiredMilkAmount = requiredMilkAmount;
    }
}