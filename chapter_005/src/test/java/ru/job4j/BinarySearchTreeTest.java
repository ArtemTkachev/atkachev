package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BinarySearchTreeTest {

    @Test
    public void when6ElFindLastThen6() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }
}
