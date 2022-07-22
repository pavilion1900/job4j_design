package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {
    void parkCars(List<Car> carList);

    int getFreeParkingPlacesForSmallCars();

    int getFreeParkingPlacesForBigCars();
}
