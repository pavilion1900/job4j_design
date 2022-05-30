package ru.job4j.ood.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report<String> engine = new ReportEngine(store, new OldDepartment());
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Pavel", now, now, 150);
        Employee worker3 = new Employee("Roman", now, now, 70);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        Report<String> engine = new ReportEngine(store, new ITDepartment());
        String ln = System.lineSeparator();
        StringBuilder expect = new StringBuilder()
                .append("<!doctype html>").append(ln)
                .append("<html lang=\"ru\">").append(ln)
                .append("<head>").append(ln)
                .append("<meta charset=\"utf-8\" />").append(ln)
                .append("</head>").append(ln)
                .append("<body>").append(ln)
                .append("<p>name: Ivan</p>").append(ln)
                .append("<p>salary: 100.0</p>").append(ln)
                .append("<p>name: Pavel</p>").append(ln)
                .append("<p>salary: 150.0</p>").append(ln)
                .append("<p>name: Roman</p>").append(ln)
                .append("<p>salary: 70.0</p>").append(ln)
                .append("</body>").append(ln)
                .append("</html>").append(ln);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100.25);
        store.add(worker);
        Report<String> engine = new ReportEngine(store, new AccountingDepartment());
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("100 руб 25 коп").append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Pavel", now, now, 150);
        Employee worker3 = new Employee("Roman", now, now, 70);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        String ln = System.lineSeparator();
        Report<String> engine = new ReportEngine(store, new HRDepartment());
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(ln)
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(ln)
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(ln)
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}