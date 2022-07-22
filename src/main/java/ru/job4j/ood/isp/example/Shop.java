package ru.job4j.ood.isp.example;

import java.util.List;

public interface Shop {
    void acceptProducts(List<Product> productList);

    double sellProduct(List<Product> productList);

    void delivery();
}
