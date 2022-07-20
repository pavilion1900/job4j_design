package ru.job4j.ood.tdd.condition;

public class SqMax {
    public int max(int first, int second, int third, int fourth) {
        return max(
                max(first, second),
                max(third, fourth)
        );
    }

    public int max(int left, int right) {
        return left > right ? left : right;
    }
}
