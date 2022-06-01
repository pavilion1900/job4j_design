package ru.job4j.ood.lsp;

public class PresentFromUncle extends Present {
    public PresentFromUncle(Student student) {
        super(student);
    }

    @Override
    public void setStudent(Student student) {
        this.student = student;
    }
}
