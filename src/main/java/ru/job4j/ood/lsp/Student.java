package ru.job4j.ood.lsp;

public class Student {
    private String name;
    private double avgScore;

    public Student(String name, double avgScore) {
        this.name = name;
        this.avgScore = avgScore;
    }

    public String getName() {
        return name;
    }

    public double getAvgScore() {
        return avgScore;
    }
}
