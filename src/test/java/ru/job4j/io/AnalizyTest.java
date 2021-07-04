package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenServer1() {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server1.log", "./data/unavailable1.csv");
        String exp = "10:57:01;10:59:01;" + System.lineSeparator()
                + "11:01:02;11:02:02;" + System.lineSeparator();
        String rsl = null;
        try (BufferedReader in = new BufferedReader(new FileReader("./data/unavailable1.csv"))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                text.append(line + System.lineSeparator());
            }
            rsl = text.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(rsl, is(exp));
    }

    @Test
    public void whenServer2() {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server2.log", "./data/unavailable2.csv");
        String exp = "10:57:01;11:02:02;" + System.lineSeparator();
        String rsl = null;
        try (BufferedReader in = new BufferedReader(new FileReader("./data/unavailable2.csv"))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                text.append(line + System.lineSeparator());
            }
            rsl = text.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(rsl, is(exp));
    }

    @Test
    public void whenServer1TempFolder() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator()
                    + "500 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "200 10:59:01" + System.lineSeparator()
                    + "500 11:01:02" + System.lineSeparator()
                    + "300 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:01;" + "11:01:02;11:02:02;"));
    }

    @Test
    public void whenServer2TempFolder() throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator()
                    + "500 10:57:01" + System.lineSeparator()
                    + "400 10:58:01" + System.lineSeparator()
                    + "500 10:59:01" + System.lineSeparator()
                    + "400 11:01:02" + System.lineSeparator()
                    + "200 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01;11:02:02;"));
    }
}