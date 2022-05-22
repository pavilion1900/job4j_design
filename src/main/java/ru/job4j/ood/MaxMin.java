package ru.job4j.ood;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findValue(value, (result, element) -> comparator.compare(result, element) < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findValue(value, (result, element) -> comparator.compare(result, element) > 0);
    }

    public <T> T findValue(List<T> value, BiPredicate<T, T> predicate) {
        T result = value.get(0);
        for (T element : value) {
            if (predicate.test(result, element)) {
                result = element;
            }
        }
        return result;
    }
}
