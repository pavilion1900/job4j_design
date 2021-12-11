package ru.job4j.io.exam;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Predicate;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;

public class FindFiles extends SimpleFileVisitor<Path> {
    private Predicate<Path> predicate;
    private List<Path> list = new ArrayList<>();

    public FindFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public List<Path> getList() {
        return list;
    }

    public static List<Path> search(Path path, Predicate<Path> predicate) throws IOException {
        FindFiles findFiles = new FindFiles(predicate);
        Files.walkFileTree(path, findFiles);
        return findFiles.getList();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            list.add(file);
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return SKIP_SUBTREE;
    }
}
