package ru.job4j.cache;

import java.util.*;

public class Emulator {
    private AbstractCache<String, String> cache;

    public void setCachingDirectory(String pathDirectory) {
        cache = new DirFileCache(pathDirectory);
    }

    public void loadDataToCache(String pathFile) {
        cache.put(pathFile, cache.load(pathFile));
    }

    public String getData(String pathFile) {
        return cache.get(pathFile);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter caching directory: ");
        setCachingDirectory(scanner.next());
        System.out.print("Load data to cache: ");
        String pathFile = scanner.next();
        if (!"no".equals(pathFile)) {
            loadDataToCache(pathFile);
        }
        boolean run = true;
        while (run) {
            System.out.print("Select data: ");
            String pathFileData = scanner.next();
            if ("stop".equals(pathFileData)) {
                break;
            }
            System.out.println(getData(pathFileData));
        }
    }

    public void run(List<String> actions) {
        System.out.print("Enter caching directory: ");
        int index = 0;
        String pathDirectory = actions.get(index++);
        System.out.println(pathDirectory);
        setCachingDirectory(pathDirectory);
        System.out.print("Load data to cache: ");
        String pathFile = actions.get(index++);
        System.out.println(pathFile);
        if (!"no".equals(pathFile)) {
            loadDataToCache(pathFile);
        }
        boolean run = true;
        while (run) {
            System.out.print("Select data: ");
            String pathFileData = actions.get(index++);
            System.out.println(pathFileData);
            if ("stop".equals(pathFileData)) {
                break;
            }
            System.out.println(getData(pathFileData));
        }
    }

    public static void main(String[] args) {
        List<String> actions = List.of(
                "src/main/java/ru/job4j/cache/dir",
                "Addresses.txt",
                "Addresses.txt",
                "Cities.txt",
                "Names.txt",
                "stop");
        new Emulator().run(actions);
    }
}
