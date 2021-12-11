package ru.job4j.io.exam;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;

public class FindData {
    public static void validate(String[] args) {
        if (args.length > 0 && args.length < 4) {
            throw new IllegalArgumentException("Not enough arguments. "
                    + "Check next arguments: directory, fileFind, typeSearch, output");
        } else if (args.length > 4) {
            throw new IllegalArgumentException("Arguments are more than need. "
                    + "Delete unnecessary arguments");
        }
    }

    private static void validateArguments(Arguments arguments) {
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

    private static void showInfo(File output, List<Path> rsl) throws IOException {
        if ("stdout".equals(output.getName())) {
            rsl.forEach(System.out::print);
        } else {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(output)))) {
                rsl.forEach(out::println);
            }
        }
    }

    private static List<Path> listData(Path directory, String fileFind, String typeSearch)
            throws IOException {
        List<Path> list = new ArrayList<>();
        Predicate<Path> maskPredicate =
                elem -> elem.toFile().getName().toLowerCase().endsWith(fileFind.substring(1));
        Predicate<Path> namePredicate = elem -> elem.toFile().getName().equals(fileFind);
        if ("mask".equals(typeSearch)) {
            list = FindFiles.search(directory, maskPredicate);
        } else if ("name".equals(typeSearch)) {
            list = FindFiles.search(directory, namePredicate);
        }
        return list;
    }

    public static void handle(Arguments arguments) throws Exception {
        validateArguments(arguments);
        Path directory = Path.of(arguments.getValue("d"));
        String fileFind = arguments.getValue("n");
        String typeSearch = arguments.getValue("t");
        File output = new File(arguments.getValue("o"));
        List<Path> list = listData(directory, fileFind, typeSearch);
        showInfo(output, list);
    }
}
