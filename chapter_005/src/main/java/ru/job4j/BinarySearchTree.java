package ru.job4j;

import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> {
    private final Node<E> root;

    public BinarySearchTree(E value) {
        root = new Node<>(value);
    }

    public boolean add(E e) {
        boolean rsl = false;
        if (!this.findBy(e).isPresent()) {
            Queue<Node<E>> data = new LinkedList<>();
            data.offer(this.root);
            while (!data.isEmpty()) {
                Node<E> el = data.poll();
                if (el.leaves().size() < 2) {
                    el.add(new Node<>(e));
                    rsl = true;
                    break;
                }
                for (Node<E> child : el.leaves()) {
                    data.offer(child);
                }
            }
        }
        return rsl;
    }

    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }
}
