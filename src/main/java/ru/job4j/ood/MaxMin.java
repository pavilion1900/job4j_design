package ru.job4j.ood;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        List<T> temp = new ArrayList<>(value);
        temp.sort(comparator.reversed());
        return temp.get(0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        List<T> temp = new ArrayList<>(value);
        temp.sort(comparator);
        return temp.get(0);
    }
}
