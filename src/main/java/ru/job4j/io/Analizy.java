package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String line;
            List<Integer> temp = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                String[] array = line.split(" ");
                if (Integer.parseInt(array[0]) == 400 || Integer.parseInt(array[0]) == 500) {
                    if (temp.contains(400) || temp.contains(500)) {
                        continue;
                    }
                    out.print(array[1] + ";");
                } else if (Integer.parseInt(array[0]) == 200 || Integer.parseInt(array[0]) == 300) {
                    if (temp.contains(200) || temp.contains(300)) {
                        out.println(array[1] + ";");
                        temp = new ArrayList<>();
                    }
                }
                temp.add(Integer.parseInt(array[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
