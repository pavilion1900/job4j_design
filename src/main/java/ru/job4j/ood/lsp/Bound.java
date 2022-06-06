package ru.job4j.ood.lsp;

public enum Bound {
    MIN(25),
    AVG(75),
    MAX(100);

    private final int value;

    Bound(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
