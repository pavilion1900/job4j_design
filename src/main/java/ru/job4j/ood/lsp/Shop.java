package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> foodList = new ArrayList<>();

    @Override
    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }

    @Override
    public boolean sortProduct(Food food) {
        if (accept(food)) {
            if (getUsageExpirationDate(food) > 75 && getUsageExpirationDate(food) < 100) {
                food.setPrice(food.getPrice() * (100 - food.getDiscount()) / 100);
            }
            foodList.add(food);
        }
        return accept(food);
    }

    @Override
    public boolean accept(Food food) {
        return getUsageExpirationDate(food) >= 25 && getUsageExpirationDate(food) < 100;
    }
}
