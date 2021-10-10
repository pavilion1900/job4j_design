package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path elem : sources) {
                zip.putNextEntry(new ZipEntry(elem.toFile().getAbsolutePath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(elem.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null");
        }
        if (args.length < 3) {
            throw new IllegalArgumentException("Not enough arguments");
        }
        ArgsName argsName = ArgsName.of(args);
        Path path = Path.of(argsName.get("d"));
        String extension = argsName.get("e");
        File target = new File(argsName.get("o"));
        List<Path> files = Search.search(path, elem -> !elem.toFile().getName()
                .endsWith(extension));
        packFiles(files, target);
    }
}
