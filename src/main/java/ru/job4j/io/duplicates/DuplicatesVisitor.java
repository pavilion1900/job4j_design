package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, Path> map = new HashMap<>();
    private List<Path> list = new ArrayList<>();

    public List<Path> getList() {
        return list;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        FileProperty fileProperty = new FileProperty(
                file.toFile().length(), file.toFile().getName());
        if (!map.containsKey(fileProperty)) {
            map.put(fileProperty, file);
        } else {
            list.add(map.get(fileProperty));
            list.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
