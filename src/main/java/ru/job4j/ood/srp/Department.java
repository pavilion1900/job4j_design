package ru.job4j.ood.srp;

import java.util.List;

public interface Department<T> {
    T format(List<Employee> employeeList);
}
