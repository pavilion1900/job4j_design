package ru.job4j.ood.srp;

public class Shop {
    public boolean acceptingGoods(Good good) {
        return !good.isExpireDate();
    }

    public void tradingGoods(Good good) {
    }

    public boolean sendingGoods(Good good) {
        return good.isExpireDate();
    }
}