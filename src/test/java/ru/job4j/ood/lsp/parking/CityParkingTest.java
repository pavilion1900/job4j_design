package ru.job4j.ood.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Ignore
public class CityParkingTest {
    @Test
    public void whenParkTwoSmallAndOneBigCars() {
        Parking parking = new CityParking(2, 1);
        List<Car> carList = List.of(new SmallCar(), new SmallCar(), new BigCar(2));
        parking.parkCars(carList);
        assertThat(parking.getFreeParkingPlacesForSmallCars(), is(0));
        assertThat(parking.getFreeParkingPlacesForBigCars(), is(0));
    }

    @Test
    public void whenParkTwoBigCars() {
        Parking parking = new CityParking(2, 1);
        List<Car> carList = List.of(new BigCar(5), new BigCar(2));
        parking.parkCars(carList);
        assertThat(parking.getFreeParkingPlacesForSmallCars(), is(0));
        assertThat(parking.getFreeParkingPlacesForBigCars(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParkBigCarWithIncorrectSize() {
        Parking parking = new CityParking(2, 1);
        List<Car> carList = List.of(new BigCar(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParkSmallCarWithoutFreeParkingPlace() {
        Parking parking = new CityParking(0, 1);
        List<Car> carList = List.of(new SmallCar());
        parking.parkCars(carList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParkBigCarWithoutFreeParkingPlace() {
        Parking parking = new CityParking(1, 0);
        List<Car> carList = List.of(new BigCar(2));
        parking.parkCars(carList);
    }
}