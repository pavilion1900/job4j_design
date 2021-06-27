package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

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
}