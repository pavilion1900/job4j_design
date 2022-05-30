package ru.job4j.ood.srp;

import java.util.List;

public class OldDepartment implements Department<String> {
    @Override
    public String format(List<Employee> employeeList) {
        StringBuilder text = new StringBuilder()
                .append("Name; Hired; Fired; Salary;");
        for (Employee employee : employeeList) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
