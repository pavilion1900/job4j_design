package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRDepartment implements Report<String> {
    private Store store;

    public HRDepartment(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Comparator<Employee> sortSalaryDesc = Comparator.comparing(Employee::getSalary).reversed();
        List<Employee> employeeList = store.findBy(filter);
        employeeList.sort(sortSalaryDesc);
        StringBuilder text = new StringBuilder()
                .append("Name; Salary;");
        for (Employee employee : employeeList) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}