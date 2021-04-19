package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int add = 0;
        int change = 0;
        int delete = 0;
        Map<Integer, String> mapPrev = new HashMap<>();
        for (User prevUser : previous) {
            mapPrev.put(prevUser.getId(), prevUser.getName());
        }
        for (User currentUser : current) {
            if (mapPrev.get(currentUser.getId()) == null) {
                add++;
            } else if (mapPrev.get(currentUser.getId()) != null
                    && !mapPrev.get(currentUser.getId()).equals(currentUser.getName())) {
                change++;
            }
        }
        Map<Integer, String> mapCurrent = new HashMap<>();
        for (User currentUser : current) {
            mapCurrent.put(currentUser.getId(), currentUser.getName());
        }
        for (User prevUser : previous) {
            if (mapCurrent.get(prevUser.getId()) == null) {
                delete++;
            }
        }
        return new Info(add, change, delete);
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added && changed == info.changed && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
