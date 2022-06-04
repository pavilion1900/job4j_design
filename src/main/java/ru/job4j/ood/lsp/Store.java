package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public interface Store {
    int MIN_BOUND = 25;
    int AVG_BOUND = 75;
    int MAX_BOUND = 100;

    List<Food> getFoodList();

    boolean sortProduct(Food food);

    boolean accept(Food food);

    default long getUsageExpirationDate(Food food) {
        long restOfExpirationDate = DAYS.between(LocalDate.now(), food.getExpireDate());
        long fullExpirationDate = DAYS.between(food.getCreateDate(), food.getExpireDate());
        return (fullExpirationDate - restOfExpirationDate) * MAX_BOUND / fullExpirationDate;
    }
}
