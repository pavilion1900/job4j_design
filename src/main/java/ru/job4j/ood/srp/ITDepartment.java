package ru.job4j.ood.srp;

import java.util.List;

public class ITDepartment implements Department<String> {
    @Override
    public String format(List<Employee> employeeList) {
        String ln = System.lineSeparator();
        StringBuilder text = new StringBuilder()
                .append("<!doctype html>").append(ln)
                .append("<html lang=\"ru\">").append(ln)
                .append("<head>").append(ln)
                .append("<meta charset=\"utf-8\" />").append(ln)
                .append("</head>").append(ln)
                .append("<body>").append(ln);
        for (Employee employee : employeeList) {
            text.append("<p>name: " + employee.getName() + "</p>").append(ln)
                    .append("<p>salary: " + employee.getSalary() + "</p>").append(ln);
        }
        text.append("</body>").append(ln)
                .append("</html>").append(ln);
        return text.toString();
    }
}
