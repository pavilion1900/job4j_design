package ru.job4j.ood.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.junit.Assert.*;

@Ignore
public class QuestionGeneratorTest {

    @Test
    public void produceWithCorrectData() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.ofEntries(
                entry("name", "Petr Arsentev"),
                entry("subject", "you")
        );
        Generator generator = new QuestionGenerator();
        String generatedString = generator.produce(template, args);
        assertTrue(generatedString.matches("I am a \\w+\\s?\\w+, Who are \\w+\\? "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void produceWithInvalidTemplateKeys() {
        String template = "I am a ${id}, Who are ${date}? ";
        Map<String, String> args = Map.ofEntries(
                entry("name", "Petr Arsentev"),
                entry("subject", "you")
        );
        Generator generator = new QuestionGenerator();
        generator.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produceWithExtraKeysInMap() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.ofEntries(
                entry("name", "Petr Arsentev"),
                entry("subject", "you"),
                entry("city", "Gomel"),
                entry("street", "River")
        );
        Generator generator = new QuestionGenerator();
        generator.produce(template, args);
    }
}