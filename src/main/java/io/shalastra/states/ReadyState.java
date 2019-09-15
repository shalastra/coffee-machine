package io.shalastra.states;

import io.shalastra.models.Coffee;
import io.shalastra.models.CoffeeType;
import io.shalastra.services.CoffeeMachineService;
import lombok.extern.slf4j.Slf4j;

import java.util.EnumMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ReadyState implements State {

    @Override
    public void nextState(CoffeeMachineService service) {
        log.info("Please select a coffee you would like to drink today. (0 - quit).");

        printCoffeeList(service.getCoffeeMachine().getAvailableCoffees());
        readInput(service);
    }

    private void readInput(CoffeeMachineService service) {
        Scanner scanner = new Scanner(System.in);

        try {
            int selectedCoffee = scanner.nextInt();

            if (selectedCoffee == 0) {
                service.setCurrentState(new OffState());
            } else {
                service.setCurrentState(new BrewCoffeeState(CoffeeType.values()[selectedCoffee - 1]));
            }

        } catch (ArrayIndexOutOfBoundsException ex) {
            log.warn("You cannot choose that option, selected option doesn't exist.");
            service.setCurrentState(this);
        }
    }

    private void printCoffeeList(EnumMap<CoffeeType, Coffee> availableCoffees) {
        AtomicInteger counter = new AtomicInteger();

        availableCoffees.values().stream()
                .map(coffee -> coffee.getName().toUpperCase())
                .forEach(coffeeName -> log.info(counter.incrementAndGet() + " - " + coffeeName));
    }

    @Override
    public void printStatus() {
        log.info("Coffee machine is ready to use.");
    }
}