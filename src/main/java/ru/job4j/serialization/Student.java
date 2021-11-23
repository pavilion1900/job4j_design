package ru.job4j.serialization;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @XmlAttribute
    private int id;
    @XmlAttribute
    private String surname;
    @XmlAttribute
    private boolean job;
    private Scooter scooter;
    @XmlElementWrapper(name = "hobbies")
    @XmlElement(name = "hobby")
    private String[] hobbies;

    public Student() {
    }

    public Student(int id, String surname, boolean job, Scooter scooter, String[] hobbies) {
        this.id = id;
        this.surname = surname;
        this.job = job;
        this.scooter = scooter;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isJob() {
        return job;
    }

    public Scooter getScooter() {
        return scooter;
    }

    public String[] getHobbies() {
        return hobbies;
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
