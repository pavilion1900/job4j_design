package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("log.txt"))) {
            List<String> text = new ArrayList<>();
            String line;
            while ((line = buffer.readLine()) != null) {
                text.add(line);
            }
            for (String elem : text) {
                String[] temp = elem.split(" ");
                if (Integer.parseInt(temp[temp.length - 2]) == 404) {
                    rsl.add(elem);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
    }
}
