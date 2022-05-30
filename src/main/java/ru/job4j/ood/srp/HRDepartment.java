package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.List;

public class HRDepartment implements Department<String> {
    @Override
    public String format(List<Employee> employeeList) {
        Comparator<Employee> sortSalaryDesc = Comparator.comparing(Employee::getSalary).reversed();
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