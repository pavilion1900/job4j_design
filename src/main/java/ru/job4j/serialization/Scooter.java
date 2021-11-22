package ru.job4j.serialization;

public class Scooter {
    private final String model;
    private final int speed;

    public Scooter(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Scooter{" + "model='" + model + '\''
                + ", speed=" + speed + '}';
    }
}
