package ru.job4j.ood.srp;

import org.junit.Test;

import java.text.SimpleDateFormat;
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
        Report<String> engine = new ReportEngine(store);
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
        Report<String> engine = new ITDepartment(store);
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
        Report<String> engine = new AccountingDepartment(store, 1.2);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append("120.3").append(";");
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
        Report<String> engine = new HRDepartment(store);
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

    @Test
    public void whenGeneratedToJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
        int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report<String> engine = new JSONReport(store);
        String expect = "[{\"name\":\"Ivan\",\"hired\":{\"year\":" + year + ",\"month\":" + month
                + ",\"dayOfMonth\":" + dayOfMonth + ",\"hourOfDay\":" + hourOfDay
                + ",\"minute\":" + minute + ",\"second\":" + second + "},\"fired\":{\"year\":"
                + year + ",\"month\":" + month + ",\"dayOfMonth\":" + dayOfMonth
                + ",\"hourOfDay\":" + hourOfDay + ",\"minute\":" + minute + ",\"second\":"
                + second + "},\"salary\":100.0}]";
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenGeneratedToXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Pavel", now, now, 150);
        store.add(worker);
        store.add(worker2);
        Report<String> engine = new XMLReport(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employeesList>\n"
                + "        <employee>\n"
                + "            <fired>" + dateFormat.format(worker.getFired().getTime())
                + "</fired>\n"
                + "            <hired>" + dateFormat.format(worker.getHired().getTime())
                + "</hired>\n"
                + "            <name>Ivan</name>\n"
                + "            <salary>100.0</salary>\n"
                + "        </employee>\n"
                + "        <employee>\n"
                + "            <fired>" + dateFormat.format(worker2.getFired().getTime())
                + "</fired>\n"
                + "            <hired>" + dateFormat.format(worker2.getHired().getTime())
                + "</hired>\n"
                + "            <name>Pavel</name>\n"
                + "            <salary>150.0</salary>\n"
                + "        </employee>\n"
                + "    </employeesList>\n"
                + "</employees>\n";
        assertThat(engine.generate(em -> true), is(expect));
    }
}