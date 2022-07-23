package ru.job4j.ood.lsp.parking;

import java.util.List;

public class CityParking implements Parking {

    public CityParking(int parkingPlaceSmallCar, int parkingPlaceBigCar) {
    }

    @Override
    public void parkCars(List<Car> carList) {
    }

    @Override
    public int getFreeParkingPlacesForSmallCars() {
        return -1;
    }

    @Override
    public int getFreeParkingPlacesForBigCars() {
        return -1;
    }
}
