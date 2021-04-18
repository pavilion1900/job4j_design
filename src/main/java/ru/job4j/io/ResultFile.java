package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            int[][] table = Matrix.multiple(9);
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    out.write(String.format("%4d", table[i][j]).getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
