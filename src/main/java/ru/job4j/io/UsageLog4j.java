package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte first = 100;
        short second = 30_000;
        int third = 1_000_000;
        long forth = 5_000_000_000L;
        float fifth = 3.14f;
        double sixth = 155.37;
        char seventh = 'S';
        boolean eighth = true;
        LOG.debug("Data info first : {}, second : {}, third : {}, forth : {}, fifth : {}, "
                        + "sixth : {}, seventh : {}, eighth : {}", first, second, third,
                forth, fifth, sixth, seventh, eighth);
    }
}
