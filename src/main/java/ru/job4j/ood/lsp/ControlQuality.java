package ru.job4j.ood.lsp;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControlQuality {
    private Store store;
    private LocalDate localDate;

    public ControlQuality(Store store, LocalDate localDate) {
        this.store = store;
        this.localDate = localDate;
    }

    public void checkProduct(Food food) {
        long usageExpirationDate = getUsageExpirationDate(food);
        store.sortProduct(food, usageExpirationDate);
    }

    private long getUsageExpirationDate(Food food) {
        long restOfExpirationDate = DAYS.between(localDate, food.getExpireDate());
        long fullExpirationDate = DAYS.between(food.getCreateDate(), food.getExpireDate());
        return (fullExpirationDate - restOfExpirationDate) * 100 / fullExpirationDate;
    }
}
