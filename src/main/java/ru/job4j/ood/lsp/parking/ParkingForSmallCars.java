package ru.job4j.ood.lsp.parking;

public class ParkingForSmallCars implements ParkingForCars {
    public ParkingForSmallCars(int parkingPlace) {
    }

    @Override
    public int getFreeParkingPlaces() {
        return -1;
    }

    public void setParkingPlace(int parkingPlace) {
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
