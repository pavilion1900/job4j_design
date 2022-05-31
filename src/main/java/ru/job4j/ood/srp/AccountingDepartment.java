package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

public class AccountingDepartment implements Report<String> {
    private Store store;
    private double index;

    public AccountingDepartment(Store store, double index) {
        this.store = store;
        this.index = index;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employeeList = store.findBy(filter);
        StringBuilder text = new StringBuilder()
                .append("Name; Hired; Fired; Salary;");
        for (Employee employee : employeeList) {
            String salary = String.valueOf(employee.getSalary() * index);
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(salary).append(";");
        }
        return text.toString();
    }
}
