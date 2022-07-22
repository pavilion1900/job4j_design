package ru.job4j.ood.isp.example;

import java.util.List;

public interface Report {
    void generateExcel(List<Product> productList);

    void generateWord(List<Product> productList);

    void generatePdf(List<Product> productList);
}
