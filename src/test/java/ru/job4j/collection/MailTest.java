package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MailTest {

    @Test
    public void checkMail() {
        Set<String> emailUser1 = new LinkedHashSet<>(
                List.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        Set<String> emailUser2 = new LinkedHashSet<>(List.of("ups@pisem.net", "foo@gmail.com"));
        Set<String> emailUser3 = new LinkedHashSet<>(List.of("xyz@pisem.net", "vasya@pupkin.com"));
        Set<String> emailUser4 = new LinkedHashSet<>(List.of("ups@pisem.net", "aaa@bbb.ru"));
        Set<String> emailUser5 = new LinkedHashSet<>(List.of("xyz@pisem.net", "abc@pisem.net"));
        Map<String, Set<String>> personEmails = new LinkedHashMap<>();
        personEmails.put("user1", emailUser1);
        personEmails.put("user2", emailUser2);
        personEmails.put("user3", emailUser3);
        personEmails.put("user4", emailUser4);
        personEmails.put("user5", emailUser5);
        Mail mail = new Mail();
        Map<String, Set<String>> rsl = mail.checkMails(personEmails);
        Map<String, Set<String>> exp = Map.of(
                "user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru",
                        "ups@pisem.net", "aaa@bbb.ru"),
                "user3", Set.of("xyz@pisem.net", "vasya@pupkin.com", "abc@pisem.net"));
        assertThat(exp, is(rsl));
    }

    @Test
    public void whenAllEmailsEquals() {
        Set<String> emailUser1 = new LinkedHashSet<>(List.of("xxx@ya.ru"));
        Set<String> emailUser2 = new LinkedHashSet<>(List.of("xxx@ya.ru"));
        Set<String> emailUser3 = new LinkedHashSet<>(List.of("xxx@ya.ru"));
        Set<String> emailUser4 = new LinkedHashSet<>(List.of("xxx@ya.ru"));
        Set<String> emailUser5 = new LinkedHashSet<>(List.of("xxx@ya.ru"));
        Map<String, Set<String>> personEmails = new LinkedHashMap<>();
        personEmails.put("user1", emailUser1);
        personEmails.put("user2", emailUser2);
        personEmails.put("user3", emailUser3);
        personEmails.put("user4", emailUser4);
        personEmails.put("user5", emailUser5);
        Mail mail = new Mail();
        Map<String, Set<String>> rsl = mail.checkMails(personEmails);
        Map<String, Set<String>> exp = Map.of("user1", Set.of("xxx@ya.ru"));
        assertThat(exp, is(rsl));
    }
}