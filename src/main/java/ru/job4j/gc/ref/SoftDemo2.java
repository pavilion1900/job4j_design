package ru.job4j.gc.ref;

import java.io.*;
import java.lang.ref.SoftReference;

public class SoftDemo2 {
    private static final String BIG_FILE = "src/main/resources/bigFile.txt";
    private SoftReference<FileReader> softReference = new SoftReference<>(readBigText());

    public FileReader readBigText() {
        FileReader in = null;
        try {
            in = new FileReader(BIG_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    public void makeNewFile(String path) {
        FileReader strongReference = softReference.get();
        if (strongReference == null) {
            strongReference = readBigText();
            softReference = new SoftReference<>(strongReference);
        }
        try (BufferedReader in = new BufferedReader(strongReference);
             PrintWriter out = new PrintWriter(new FileWriter(path))) {
            in.lines()
                    .limit(20)
                    .forEach(elem -> out.println(elem));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SoftDemo2().makeNewFile("src/main/resources/newFile.txt");
    }
}