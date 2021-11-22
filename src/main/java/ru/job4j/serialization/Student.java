package ru.job4j.serialization;

import java.util.Arrays;

public class Student {
    private final int id;
    private final String surname;
    private final boolean job;
    private final Scooter scooter;
    private final String[] hobbies;

    public Student(int id, String surname, boolean job, Scooter scooter, String[] hobbies) {
        this.id = id;
        this.surname = surname;
        this.job = job;
        this.scooter = scooter;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id
                + ", surname='" + surname + '\''
                + ", job=" + job
                + ", scooter=" + scooter
                + ", hobbies=" + Arrays.toString(hobbies) + '}';
    }
}
