package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                new FileReader(path, Charset.forName("WINDOWS-1251")))) {
            in.lines().forEach(elem -> text.append(elem + System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public void writeDataInFile(String path, List<String> data) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            data.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "src/main/resources/example.txt";
        UsageEncoding encoding = new UsageEncoding();
        List<String> list = List.of(
                "Новая строка 1",
                "Новая строка 2",
                "Новая строка 3",
                "Новая строка 4",
                "Новая строка 5"
        );
        encoding.writeDataInFile(path, list);
        String s = encoding.readFile(path);
        System.out.println("Данные из файла: ");
        System.out.println(s);
    }
}
