package ru.job4j.ood.srp;

import java.util.List;

public class AccountingDepartment implements Department<String> {
    @Override
    public String format(List<Employee> employeeList) {
        StringBuilder text = new StringBuilder()
                .append("Name; Hired; Fired; Salary;");
        for (Employee employee : employeeList) {
            String salary = String.valueOf(employee.getSalary());
            salary = salary.replaceAll("(\\d+)\\.(\\d+)", "$1 руб $2 коп");
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(salary).append(";");
        }
        return text.toString();
    }
}
