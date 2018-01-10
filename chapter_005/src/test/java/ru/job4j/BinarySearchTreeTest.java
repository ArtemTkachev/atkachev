package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BinarySearchTreeTest {

    @Test
    public void when6ElFindLastThen6() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(6);
        tree.add(7);
        tree.add(5);
        tree.add(4);
        tree.add(1);
        tree.add(8);
        assertThat(tree.findBy(8).isPresent(), is(true));
    }
}
