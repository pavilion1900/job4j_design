package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String question;
        String answer;
        boolean rsl = true;
        while (rsl) {
            question = scanner.nextLine();
            if (OUT.equals(question)) {
                log.add("User: " + question);
                rsl = false;
            } else if (STOP.equals(question)) {
                while (!CONTINUE.equals(question)) {
                    log.add("User: " + question);
                    question = scanner.nextLine();
                }
                log.add("User: " + question);
            } else {
                answer = readPhrases().get(random.nextInt(readPhrases().size()));
                log.add("User: " + question);
                log.add("Bot: " + answer);
                System.out.println(answer);
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(this.botAnswers, Charset.forName("WINDOWS-1251")))) {
            in.lines().forEach(rsl::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(this.path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("dialog.txt", "answers.txt");
        cc.run();
    }
}