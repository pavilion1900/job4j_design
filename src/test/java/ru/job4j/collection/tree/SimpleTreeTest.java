package ru.job4j.collection.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenAddIdenticalElements() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        tree.add(5, 2);
        tree.add(5, 4);
        assertFalse(tree.findBy(5).get().getChildren().contains(2));
        assertFalse(tree.findBy(5).get().getChildren().contains(4));
    }

    @Test
    public void whenTreeIsBinary() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 4);
        tree.add(2, 7);
        tree.add(2, 8);
        tree.add(4, 5);
        tree.add(4, 3);
        tree.add(5, 6);
        tree.add(5, 9);
        assertTrue(tree.isBinary());
    }

    @Test
    public void whenTreeIsNotBinary() {
        Tree<Integer> tree = new SimpleTree<>(1);
        tree.add(1, 2);
        tree.add(1, 4);
        tree.add(2, 7);
        tree.add(2, 8);
        tree.add(4, 5);
        tree.add(4, 3);
        tree.add(5, 6);
        tree.add(5, 9);
        tree.add(5, 10);
        assertFalse(tree.isBinary());
    }
}