package ru.job4j.ood.lsp;

public class HomeBank extends Bank {
    public HomeBank(Person person) {
        super(person);
    }

    @Override
    public double sizeOfCredit() {
        double salary = person.getSalary();
        if (salary < 1_200) {
            throw new IllegalArgumentException("Sorry? We can't give you a credit");
        }
        double sizeOfCredit = 5_000;
        if (salary >= 1_200 && salary < 1_400) {
            sizeOfCredit = 8_000;
        } else if (salary >= 1_400 && salary < 1_600) {
            sizeOfCredit = 10_000;
        }
        return sizeOfCredit;
    }
}
