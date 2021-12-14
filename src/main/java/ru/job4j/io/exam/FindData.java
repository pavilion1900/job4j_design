package ru.job4j.io.exam;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FindData {
    public void validate(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException(
                    "Check value next arguments: directory, fileFind, typeSearch, output");
        }
    }

    private void validateArguments(Arguments arguments) {
        if (arguments.getValue("d") == null) {
            throw new IllegalArgumentException("Not enough argument. Directory is empty");
        }
        if (arguments.getValue("n") == null) {
            throw new IllegalArgumentException("Not enough argument. FileFind is empty");
        }
        if (arguments.getValue("t") == null) {
            throw new IllegalArgumentException("Not enough argument. TypeSearch is empty");
        }
        if (arguments.getValue("o") == null) {
            throw new IllegalArgumentException("Not enough argument. Output is empty");
        }
    }

    private void showInfo(File output, Set<Path> rsl) throws IOException {
        if ("stdout".equals(output.getName())) {
            rsl.forEach(System.out::print);
        } else {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(output)))) {
                rsl.forEach(out::println);
            }
        }
    }

    private Set<Path> listData(Path directory, String fileFind, String typeSearch)
            throws IOException {
        Set<Path> set = new TreeSet<>();
        Predicate<Path> predicate;
        FindFiles findFiles;
        Pattern pattern;
        if ("name".equals(typeSearch)) {
            predicate = elem -> elem.toFile().getName().equals(fileFind);
            findFiles = new FindFiles(predicate);
            set = findFiles.search(directory, predicate);
        } else if ("mask".equals(typeSearch) || "regex".equals(typeSearch)) {
            pattern = Pattern.compile(fileFind);
            predicate = elem -> pattern.matcher(elem.toFile().getName().toLowerCase()).find();
            findFiles = new FindFiles(predicate);
            set = findFiles.search(directory, predicate);
        }
        return set;
    }

    private String convert(String fileFind, String typeSearch) {
        if ("mask".equals(typeSearch)) {
            fileFind = fileFind.replace("*", "\\w+").replace(".", "\\.");
        } else if ("regex".equals(typeSearch)) {
            fileFind = fileFind.replaceAll("[\\\\]{2}", "\\\\");
        }
        return fileFind;
    }

    public void handle(Arguments arguments) throws Exception {
        FindData findData = new FindData();
        findData.validateArguments(arguments);
        Path directory = Path.of(arguments.getValue("d"));
        String fileFind = arguments.getValue("n");
        String typeSearch = arguments.getValue("t");
        File output = new File(arguments.getValue("o"));
        fileFind = findData.convert(fileFind, typeSearch);
        Set<Path> set = findData.listData(directory, fileFind, typeSearch);
        findData.showInfo(output, set);
    }

    public static void main(String[] args) throws Exception {
        FindData findData = new FindData();
        findData.validate(args);
        Arguments arguments = new Arguments().of(args);
        findData.handle(arguments);
    }
}
