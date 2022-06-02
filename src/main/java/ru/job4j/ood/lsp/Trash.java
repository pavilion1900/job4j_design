package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> foodList = new ArrayList<>();

    @Override
    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void sortProduct(Food food, long usageExpirationDate) {
        if (usageExpirationDate >= 100) {
            foodList.add(food);
        }
    }
}
