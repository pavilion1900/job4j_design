package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Worker implements Person {
    private Jeep jeep;

    public Worker(Jeep jeep) {
        this.jeep = jeep;
    }

    @Override
    public void drive() {
        System.out.println(jeep.getName());
    }

    @Override
    public Report work(ArrayList<Task> taskList) {
        Information information = new Information("start to do report");
        System.out.println(information.getInfo());
        String result = taskList.stream()
                .map(Task::getDescription)
                .collect(Collectors.joining(System.lineSeparator()));
        return new Report(result);
    }
}
