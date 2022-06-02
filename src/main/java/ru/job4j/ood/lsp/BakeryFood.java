package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class BakeryFood extends Food {
    public BakeryFood(String name, LocalDate expireDate, LocalDate createDate,
                      double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
