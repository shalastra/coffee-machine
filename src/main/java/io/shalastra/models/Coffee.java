package io.shalastra.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Coffee {

    private final String name;
    private final Recipe recipe;
}
