package ru.job4j.ood.srp;

import java.util.function.Predicate;

public interface Report<T> {
    T generate(Predicate<Employee> filter);
}
