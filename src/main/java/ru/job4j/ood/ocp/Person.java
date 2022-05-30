package ru.job4j.ood.ocp;

import java.util.ArrayList;

public interface Person {
    void drive();

    Report work(ArrayList<Task> taskList);
}
