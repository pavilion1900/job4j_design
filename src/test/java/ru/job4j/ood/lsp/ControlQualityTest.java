package ru.job4j.ood.lsp;

import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {
    private List<Food> foodList;
    private Store warehouse = new Warehouse();
    private Store shop = new Shop();
    private Store trash = new Trash();
    private LocalDate localDate = LocalDate.of(2022, Month.JUNE, 2);
    private List<ControlQuality> controlList;

    @Before
    public void init() {
        Fruit fruit = new Fruit("orange", LocalDate.of(2022, Month.JULY, 20),
                LocalDate.of(2022, Month.MAY, 1), 3.1, 0);
        MeatFood meatFood = new MeatFood("beef", LocalDate.of(2022, Month.MAY, 20),
                LocalDate.of(2022, Month.MAY, 1), 15.3, 0);
        Vegetables vegetables = new Vegetables("cucumber", LocalDate.of(2022, Month.JUNE, 10),
                LocalDate.of(2022, Month.MAY, 1), 2.1, 0);
        BakeryFood bakeryFood = new BakeryFood("bread", LocalDate.of(2022, Month.JUNE, 7),
                LocalDate.of(2022, Month.JUNE, 1), 1.2, 0);
        foodList = List.of(fruit, meatFood, vegetables, bakeryFood);
        controlList = List.of(
                new ControlQuality(warehouse, localDate),
                new ControlQuality(shop, localDate),
                new ControlQuality(trash, localDate)
        );
    }

    @Test
    public void whenProductPutToWarehouse() {
        for (Food food : foodList) {
            for (ControlQuality controlQuality : controlList) {
                controlQuality.checkProduct(food);
            }
        }
        List<Food> expected = List.of(new BakeryFood("bread", LocalDate.of(2022, Month.JUNE, 7),
                LocalDate.of(2022, Month.JUNE, 1), 1.2, 0));
        assertThat(warehouse.getFoodList(), is(expected));
    }

    @Test
    public void whenProductPutToShop() {
        for (Food food : foodList) {
            for (ControlQuality controlQuality : controlList) {
                controlQuality.checkProduct(food);
            }
        }
        List<Food> expected = List.of(new Fruit("orange", LocalDate.of(2022, Month.JULY, 20),
                        LocalDate.of(2022, Month.MAY, 1), 3.1, 0),
                new Vegetables("cucumber", LocalDate.of(2022, Month.JUNE, 10),
                        LocalDate.of(2022, Month.MAY, 1), 2.1, 20));
        assertThat(shop.getFoodList(), is(expected));
    }

    @Test
    public void whenProductPutToTrash() {
        for (Food food : foodList) {
            for (ControlQuality controlQuality : controlList) {
                controlQuality.checkProduct(food);
            }
        }
        List<Food> expected = List.of(new MeatFood("beef", LocalDate.of(2022, Month.MAY, 20),
                LocalDate.of(2022, Month.MAY, 1), 15.3, 0));
        assertThat(trash.getFoodList(), is(expected));
    }
}