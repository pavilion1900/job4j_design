package ru.job4j.ood.lsp;

import java.util.List;

public class ControlQuality {
    private final List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void checkProduct(List<Food> foodList) {
        for (Food food : foodList) {
            for (Store store : storeList) {
                if (store.accept(food)) {
                    store.sortProduct(food);
                }
            }
        }
    }
}
