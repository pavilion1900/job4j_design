package ru.job4j.ood.tdd.lambda;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SearchTest {
    private List<File> fileList;

    @Before
    public void init() {
        File file = new File("src/main/resources/app.properties");
        File file2 = new File("src/main/resources/log4j.properties");
        File file3 = new File("src/main/resources/bigFile.txt");
        fileList = List.of(file, file2, file3);
    }

    @Test
    public void whenFindByMask() {
        Search search = new Search(fileList);
        List<File> actual = search.findByMask("\\w+File\\.txt");
        assertThat(actual, is(List.of(new File("src/main/resources/bigFile.txt"))));
    }

    @Test
    public void whenFindByName() {
        Search search = new Search(fileList);
        List<File> actual = search.findByName("log4j.properties");
        assertThat(actual, is(List.of(new File("src/main/resources/log4j.properties"))));
    }

    @Test
    public void whenFindByExt() {
        Search search = new Search(fileList);
        List<File> actual = search.findByExt(".txt");
        assertThat(actual, is(List.of(new File("src/main/resources/bigFile.txt"))));
    }
}