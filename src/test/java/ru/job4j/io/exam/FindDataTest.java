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
        File fourth = tempFolder.newFile("fourth.csv");
        File fifth = tempFolder.newFile("fifth.csv");
        File log = tempFolder.newFile("log.txt");
        String[] arrayArguments = new String[]{"-d=" + log.getParent(),
                "-n=*.txt", "-t=mask", "-o=" + log.getAbsolutePath()};
        FindData.validate(arrayArguments);
        Arguments arguments = Arguments.of(arrayArguments);
        FindData.handle(arguments);
        String exp = String.join(System.lineSeparator(), first.getAbsolutePath(),
                log.getAbsolutePath(), second.getAbsolutePath(), "");
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(log))) {
            String line;
            while ((line = in.readLine()) != null) {
                rsl.append(line + System.lineSeparator());
            }
        }
        Assert.assertEquals(exp, rsl.toString());
    }

    @Test
    public void whenUseName() throws Exception {
        File first = tempFolder.newFile("first.txt");
        File second = tempFolder.newFile("second.txt");
        File fourth = tempFolder.newFile("fourth.csv");
        File fifth = tempFolder.newFile("fifth.csv");
        File log = tempFolder.newFile("log.txt");
        String[] arrayArguments = new String[]{"-d=" + log.getParent(),
                "-n=fourth.csv", "-t=name", "-o=" + log.getAbsolutePath()};
        FindData.validate(arrayArguments);
        Arguments arguments = Arguments.of(arrayArguments);
        FindData.handle(arguments);
        String exp = String.join(System.lineSeparator(), fourth.getAbsolutePath(), "");
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(log))) {
            String line;
            while ((line = in.readLine()) != null) {
                rsl.append(line + System.lineSeparator());
            }
        }
        Assert.assertEquals(exp, rsl.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughArgument() throws Exception {
        File first = tempFolder.newFile("first.txt");
        File second = tempFolder.newFile("second.txt");
        File fourth = tempFolder.newFile("fourth.csv");
        File fifth = tempFolder.newFile("fifth.csv");
        File log = tempFolder.newFile("log.txt");
        String[] arrayArguments = new String[]{"-d=" + log.getParent(),
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