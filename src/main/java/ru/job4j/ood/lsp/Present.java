package ru.job4j.ood.lsp;

public class Present {
    @SuppressWarnings("checkstyle:VisibilityModifier")
    protected Student student;

    public Present(Student student) {
        this.student = student;
        validate();
    }

    public void setStudent(Student student) {
        validate();
        this.student = student;
    }

    public void validate() {
        if (student.getAvgScore() < 7) {
            throw new IllegalArgumentException("You need to learn better");
        }
    }
}
