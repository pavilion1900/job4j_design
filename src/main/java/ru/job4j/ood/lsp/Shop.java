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
            if (getUsageExpirationDate(food) > AVG_BOUND
                    && getUsageExpirationDate(food) < MAX_BOUND) {
                food.setPrice(food.getPrice() * (MAX_BOUND - food.getDiscount()) / MAX_BOUND);
            }
            foodList.add(food);
        }
        return accept(food);
    }

    @Override
    public boolean accept(Food food) {
        return getUsageExpirationDate(food) >= MIN_BOUND
                && getUsageExpirationDate(food) < MAX_BOUND;
    }
}
