package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {
    public static void validate(String[] args) {
        if (args.length > 0 && args.length < 4) {
            throw new IllegalArgumentException("Not enough arguments. "
                    + "Check next arguments path, out, filter, delimiter");
        } else if (args.length > 4) {
            throw new IllegalArgumentException("Arguments are more than need. "
                    + "Delete unnecessary arguments");
        }
    }

    private static List<Integer> getIndex(
            File source, String[] filterColumn, String delimiter) throws Exception {
        List<Integer> listIndex = new ArrayList<>();
        try (Scanner scanner = new Scanner(source)) {
            if (scanner.hasNext()) {
                String[] array = scanner.nextLine().split(delimiter);
                for (int i = 0; i < filterColumn.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        if (filterColumn[i].equals(array[j])) {
                            listIndex.add(i);
                        }
                    }
                }
            }
        }
        return listIndex;
    }

    private static void showInfo(File output, List<String> rsl) throws IOException {
        if ("stdout".equals(output.getName())) {
            rsl.forEach(System.out::print);
        } else {
            try (PrintWriter out = new PrintWriter(new FileWriter(output))) {
                rsl.forEach(out::print);
            }
        }
    }

    public static void handle(ArgsName argsName) throws Exception {
        File source = new File(argsName.get("path"));
        File output = new File(argsName.get("out"));
        String[] filterColumn = argsName.get("filter").split(",");
        String delimiter = argsName.get("delimiter");
        List<Integer> listIndex = getIndex(source, filterColumn, delimiter);
        List<String> rsl = new ArrayList<>();
        try (Scanner scanner = new Scanner(source)) {
            while (scanner.hasNext()) {
                String[] array = scanner.nextLine().split(delimiter);
                for (int i = 0; i < listIndex.size(); i++) {
                    if (i == listIndex.size() - 1) {
                        rsl.add(array[i]);
                        break;
                    }
                    rsl.add(array[i] + delimiter);
                }
                rsl.add(System.lineSeparator());
            }
        }
        showInfo(output, rsl);
    }
}
