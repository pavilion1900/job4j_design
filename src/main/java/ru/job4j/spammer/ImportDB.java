package ru.job4j.spammer;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(dump))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] array = line.split(";");
                    if (array.length != 2) {
                        throw new IllegalArgumentException();
                    }
                    if (array[0].isEmpty() || array[1].isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    users.add(new User(array[0], array[1]));
                }
            }
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users "
                        + "(name, email) values (?, ?);")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in =
                     new FileInputStream("./src/main/java/ru/job4j/spammer/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./src/main/java/ru/job4j/spammer/dump.txt");
        db.save(db.load());
    }
}
