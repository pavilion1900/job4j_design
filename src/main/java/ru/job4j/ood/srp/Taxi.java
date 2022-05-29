package ru.job4j.ood.srp;

public class Taxi implements Car {
    @Override
    public void transportationManyPassengers() {

    }

    @Override
    public void transportationSomePassengers() {
        System.out.println("transportationSomePassengers");
    }

    @Override
    public void transportationGoods() {

    }
}