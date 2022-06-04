package ru.job4j.ood.lsp;

import org.junit.Before;
import org.junit.Test;

import java.time.*;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {
    private List<Food> foodList;
    private Warehouse warehouse = new Warehouse();
    private Shop shop = new Shop();
    private Trash trash = new Trash();
    private List<Store> storeList;
    private ControlQuality controlQuality;

    @Before
    public void init() {
        Fruit fruit = new Fruit("orange", LocalDate.now().plusDays(48),
                LocalDate.now().minusDays(32), 3.1, 20);
        MeatFood meatFood = new MeatFood("beef", LocalDate.now().minusDays(13),
                LocalDate.now().minusDays(32), 15.3, 30);
        Vegetables vegetables = new Vegetables("cucumber", LocalDate.now().plusDays(8),
                LocalDate.now().minusDays(32), 2.1, 20);
        BakeryFood bakeryFood = new BakeryFood("bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(1), 1.2, 40);
        foodList = List.of(fruit, meatFood, vegetables, bakeryFood);
        storeList = List.of(warehouse, shop, trash);
        controlQuality = new ControlQuality(storeList);
    }

    @Test
    public void whenPutProductToWarehouse() {
        controlQuality.checkProduct(foodList);
        List<Food> expected = List.of(new BakeryFood("bread", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(1), 1.2, 40));
        assertThat(warehouse.getFoodList(), is(expected));
    }

    @Test
    public void whenPutTwoProductsToShopWithoutAndWithDiscount() {
        controlQuality.checkProduct(foodList);
        List<Food> expected = List.of(new Fruit("orange", LocalDate.now().plusDays(48),
                        LocalDate.now().minusDays(32), 3.1, 20),
                new Vegetables("cucumber", LocalDate.now().plusDays(8),
                        LocalDate.now().minusDays(32), 1.68, 20));
        assertThat(shop.getFoodList(), is(expected));
    }

    @Test
    public void whenPutProductToTrash() {
        controlQuality.checkProduct(foodList);
        List<Food> expected = List.of(new MeatFood("beef", LocalDate.now().minusDays(13),
                LocalDate.now().minusDays(32), 15.3, 30));
        assertThat(trash.getFoodList(), is(expected));
    }
}