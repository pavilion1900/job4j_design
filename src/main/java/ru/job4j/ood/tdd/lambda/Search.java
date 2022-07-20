package ru.job4j.ood.tdd.lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Search {
    private List<File> fileList;

    public Search(List<File> fileList) {
        this.fileList = fileList;
    }

    public List<File> findBy(Predicate<File> predicate) {
        List<File> result = new ArrayList<>();
        for (File file : fileList) {
            if (predicate.test(file)) {
                result.add(file);
            }
        }
        return result;
    }

    public List<File> findByMask(String mask) {
        return findBy(file -> Pattern.matches(mask, file.getName()));
    }

    public List<File> findByName(String name) {
        return findBy(file -> file.getName().equals(name));
    }

    public List<File> findByExt(String extension) {
        return findBy(file -> file.getName().endsWith(extension));
    }
}
