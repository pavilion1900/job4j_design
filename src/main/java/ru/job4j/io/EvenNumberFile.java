package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int character;
            while ((character = in.read()) != -1) {
                text.append((char) character);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String elem : lines) {
                int temp = Integer.parseInt(elem);
                if (temp % 2 == 0) {
                    System.out.println(temp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
