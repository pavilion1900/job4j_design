package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.SKIP_SUBTREE;

public class FindFiles extends SimpleFileVisitor<Path> {
    private Predicate<Path> predicate;
    private Set<Path> set = new TreeSet<>();

    public FindFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public Set<Path> getSet() {
        return set;
    }

    public static Set<Path> search(Path path, Predicate<Path> predicate) throws IOException {
        ru.job4j.io.exam.FindFiles findFiles = new ru.job4j.io.exam.FindFiles(predicate);
        Files.walkFileTree(path, findFiles);
        return findFiles.getSet();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            set.add(file);
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return SKIP_SUBTREE;
    }
}