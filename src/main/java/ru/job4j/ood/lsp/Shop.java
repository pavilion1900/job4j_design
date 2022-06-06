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
            if (getUsageExpirationDate(food) > Bound.AVG.getValue()
                    && getUsageExpirationDate(food) < Bound.MAX.getValue()) {
                food.setPrice(food.getPrice() * (Bound.MAX.getValue() - food.getDiscount())
                        / Bound.MAX.getValue());
            }
            foodList.add(food);
        }
        return accept(food);
    }

    @Override
    public boolean accept(Food food) {
        return getUsageExpirationDate(food) >= Bound.MIN.getValue()
                && getUsageExpirationDate(food) < Bound.MAX.getValue();
    }
}
