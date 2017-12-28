package ru.job4j;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
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
    public void whenTreeIsBinaryThenTrueIfNotFalse() {
        SimpleTreeCl<Integer> binTree = new SimpleTreeCl<>(1);
        binTree.add(1, 2);
        binTree.add(1, 3);
        binTree.add(2, 4);
        binTree.add(2, 5);
        binTree.add(3, 6);
        SimpleTreeCl<Integer> notBinTree = new SimpleTreeCl<>(1);
        notBinTree.add(1, 2);
        notBinTree.add(1, 3);
        notBinTree.add(1, 4);
        notBinTree.add(2, 5);
        notBinTree.add(2, 6);
        assertThat(binTree.isBinary(), is(true));
        assertThat(notBinTree.isBinary(), is(false));
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

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        SimpleTreeCl<Integer> tree = new SimpleTreeCl<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> it = tree.iterator();
        Integer vl = null;
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

}
