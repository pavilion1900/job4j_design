package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private List<Food> foodList = new ArrayList<>();

    @Override
    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void sortProduct(Food food, long usageExpirationDate) {
        int discount = 20;
        if (usageExpirationDate >= 25 && usageExpirationDate <= 75) {
            foodList.add(food);
        } else if (usageExpirationDate > 75 && usageExpirationDate < 100) {
            food.setDiscount(discount);
            foodList.add(food);
        }
    }
}
