package ru.job4j.ood.lsp;

public class Bank {
    @SuppressWarnings("checkstyle:VisibilityModifier")
    protected Person person;

    public Bank(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public double sizeOfCredit() {
        double salary = person.getSalary();
        if (salary < 1_000) {
            throw new IllegalArgumentException("Sorry? We can't give you a credit");
        }
        double sizeOfCredit = 5_000;
        if (salary >= 1_200 && salary < 1_400) {
            sizeOfCredit = 6_000;
        } else if (salary >= 1_400 && salary < 1_600) {
            sizeOfCredit = 7_000;
        }
        return sizeOfCredit;
    }
}
