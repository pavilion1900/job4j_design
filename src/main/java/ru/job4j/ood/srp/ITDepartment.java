package ru.job4j.ood.srp;

import java.util.List;
import java.util.function.Predicate;

public class ITDepartment implements Report<String> {
    private Store store;

    public ITDepartment(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employeeList = store.findBy(filter);
        String ln = System.lineSeparator();
        StringBuilder text = new StringBuilder()
                .append("<!doctype html>" + ln)
                .append("<html lang=\"ru\">" + ln)
                .append("<head>" + ln)
                .append("<meta charset=\"utf-8\" />" + ln)
                .append("</head>" + ln)
                .append("<body>" + ln);
        for (Employee employee : employeeList) {
            text.append("<p>name: " + employee.getName() + "</p>" + ln)
                    .append("<p>salary: " + employee.getSalary() + "</p>" + ln);
        }
        text.append("</body>" + ln)
                .append("</html>" + ln);
        return text.toString();
    }
}
