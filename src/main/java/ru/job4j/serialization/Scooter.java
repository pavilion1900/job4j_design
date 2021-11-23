package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "scooter")
public class Scooter {

    @XmlAttribute
    private String model;
    @XmlAttribute
    private int speed;

    public Scooter() {
    }

    public Scooter(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Scooter{" + "model='" + model + '\''
                + ", speed=" + speed + '}';
    }
}
