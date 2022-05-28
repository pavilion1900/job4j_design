package ru.job4j.ood.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static java.util.Map.entry;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@Ignore
public class QuestionGeneratorTest {

    @Test
    public void whenProduceWithCorrectData() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.ofEntries(
                entry("name", "Petr Arsentev"),
                entry("subject", "you")
        );
        Generator generator = new QuestionGenerator();
        String generatedString = generator.produce(template, args);
        assertThat(generatedString, is("I am a Petr Arsentev, Who are you? "));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenProduceWithInvalidTemplateKeys() {
        String template = "I am a ${id}, Who are ${date}? ";
        Map<String, String> args = Map.ofEntries(
                entry("name", "Petr Arsentev"),
                entry("subject", "you")
        );
        Generator generator = new QuestionGenerator();
        generator.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenProduceWithExtraKeysInMap() {
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