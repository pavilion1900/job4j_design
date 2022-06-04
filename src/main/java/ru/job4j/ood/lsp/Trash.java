package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }

    @Override
    public boolean sortProduct(Food food) {
        if (accept(food)) {
            foodList.add(food);
        }
        return accept(food);
    }

    @Override
    public boolean accept(Food food) {
        return getUsageExpirationDate(food) >= MAX_BOUND;
    }
}
