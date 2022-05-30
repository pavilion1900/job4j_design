package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportEngine<T> implements Report<T> {
    private Store store;
    private Department department;

    public ReportEngine(Store store, Department department) {
        this.store = store;
        this.department = department;
    }

    @Override
    public T generate(Predicate<Employee> filter) {
        return (T) department.format(store.findBy(filter));
    }
}
