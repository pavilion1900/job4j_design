package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class MeatFood extends Food {
    public MeatFood(String name, LocalDate expireDate, LocalDate createDate,
                    double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
