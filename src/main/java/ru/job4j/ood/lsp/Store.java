package ru.job4j.ood.lsp;

import java.util.List;

public interface Store {
    List<Food> getFoodList();

    void sortProduct(Food food, long usageExpirationDate);
}
