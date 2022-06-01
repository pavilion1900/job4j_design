package ru.job4j.ood.lsp;

public class Person {
    private String surname;
    private double salary;

    public Person(String surname, double salary) {
        this.surname = surname;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }
}
