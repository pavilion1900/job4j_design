package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private List<Food> foodList = new ArrayList<>();

    @Override
    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void sortProduct(Food food, long usageExpirationDate) {
        if (usageExpirationDate >= 0 && usageExpirationDate < 25) {
            foodList.add(food);
        }
    }
}
