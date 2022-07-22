package ru.job4j.ood.lsp.parking;

public interface ParkingForCars {
    int getFreeParkingPlaces();

    boolean addCar(Car car);

    boolean check(Car car);
}
