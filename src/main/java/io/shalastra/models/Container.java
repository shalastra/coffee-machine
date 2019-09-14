package io.shalastra.models;

import lombok.Getter;

@Getter
public class Container {

    private final int capacity;
    private int currentAmount;

    public Container(int capacity) {
        this.capacity = capacity;
        this.currentAmount = this.capacity;
    }
}
