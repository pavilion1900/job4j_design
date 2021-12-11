package ru.job4j.io.exam;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.*;

public class FindDataTest {
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void whenUseMask() throws Exception {
        File first = tempFolder.newFile("first.txt");
        File second = tempFolder.newFile("second.txt");
        File third = tempFolder.newFile("third.txt");
        File fourth = tempFolder.newFile("fourth.csv");
        File fifth = tempFolder.newFile("fifth.csv");
        File sixth = tempFolder.newFile("sixth.txt");
        File log = tempFolder.newFile("log.txt");
        String[] arrayArguments = new String[]{"-d=" + tempFolder.getRoot(),
                "-n=*.txt", "-t=mask", "-o=" + log.getAbsolutePath()};
        FindData.validate(arrayArguments);
        Arguments arguments = Arguments.of(arrayArguments);
        FindData.handle(arguments);
        String exp = String.join(System.lineSeparator(),
                "first.txt", "log.txt", "second.txt", "sixth.txt", "third.txt", "");
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(log))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] array = line.split("\\\\");
                rsl.append(array[array.length - 1] + System.lineSeparator());
            }
        }
        Assert.assertEquals(exp, rsl.toString());
    }

    @Test
    public void whenUseName() throws Exception {
        File first = tempFolder.newFile("first.txt");
        File second = tempFolder.newFile("second.txt");
        File third = tempFolder.newFile("third.txt");
        File fourth = tempFolder.newFile("fourth.csv");
        File fifth = tempFolder.newFile("fifth.csv");
        File sixth = tempFolder.newFile("sixth.txt");
        File log = tempFolder.newFile("log.txt");
        String[] arrayArguments = new String[]{"-d=" + tempFolder.getRoot(),
                "-n=fourth.csv", "-t=name", "-o=" + log.getAbsolutePath()};
        FindData.validate(arrayArguments);
        Arguments arguments = Arguments.of(arrayArguments);
        FindData.handle(arguments);
        String exp = String.join(System.lineSeparator(), "fourth.csv", "");
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(log))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] array = line.split("\\\\");
                rsl.append(array[array.length - 1] + System.lineSeparator());
            }
        }
        Assert.assertEquals(exp, rsl.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughArgument() throws Exception {
        File first = tempFolder.newFile("first.txt");
        File second = tempFolder.newFile("second.txt");
        File third = tempFolder.newFile("third.txt");
        File fourth = tempFolder.newFile("fourth.csv");
        File fifth = tempFolder.newFile("fifth.csv");
        File sixth = tempFolder.newFile("sixth.txt");
        File log = tempFolder.newFile("log.txt");
        String[] arrayArguments = new String[]{"-d=" + tempFolder.getRoot(),
                "-n=fourth.csv", "-o=" + log.getAbsolutePath()};
        FindData.validate(arrayArguments);
        Arguments arguments = Arguments.of(arrayArguments);
        FindData.handle(arguments);
        List<String> exp = List.of(
                fourth.getAbsolutePath()
        );
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(log))) {
            in.lines().forEach(rsl::add);
        }
        Assert.assertEquals(exp, rsl);
    }
}