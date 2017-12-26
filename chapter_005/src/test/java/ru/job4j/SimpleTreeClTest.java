package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleTreeClTest {
    @Test
    public void when6ElFindLastThen6() {
        SimpleTreeCl<Integer> tree = new SimpleTreeCl<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));

    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        SimpleTreeCl<Integer> tree = new SimpleTreeCl<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
}
