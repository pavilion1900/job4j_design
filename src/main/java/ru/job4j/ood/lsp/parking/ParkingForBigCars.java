package ru.job4j.ood.lsp.parking;

public class ParkingForBigCars implements ParkingForCars {

    public ParkingForBigCars(int parkingPlace, ParkingForSmallCars parkingForSmallCars) {
    }

    @Override
    public int getFreeParkingPlaces() {
        return -1;
    }

    @Override
    public boolean addCar(Car car) {
        return false;
    }

    @Override
    public boolean check(Car car) {
        return false;
    }
}
