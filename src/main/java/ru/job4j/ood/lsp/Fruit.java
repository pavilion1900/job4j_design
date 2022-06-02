package ru.job4j.ood.lsp;

import java.time.LocalDate;

public class Fruit extends Food {
    public Fruit(String name, LocalDate expireDate, LocalDate createDate,
                 double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
