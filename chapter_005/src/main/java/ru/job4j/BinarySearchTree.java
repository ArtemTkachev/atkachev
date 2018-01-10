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
                int size = el.leaves().size();
                if (size < 2) {
                    if (size > 0) {
                        int cmprrt = el.getValue().compareTo(e);
                        int cmprchrt = el.getValue().compareTo(el.leaves().get(0).getValue());
                        if(cmprrt < 0 && cmprchrt >=0 ) {
                            el.add(new Node<>(e));
                            rsl = true;
                        } else if(cmprrt >= 0 && cmprchrt < 0) {
                            Node<E> supel = el.leaves().get(0);
                            el.leaves().remove(0);
                            el.add(new Node<>(e));
                            el.add(supel);
                            rsl = true;
                        }
                    } else if (size == 0) {
                        el.add(new Node<>(e));
                        rsl = true;
                    }
                    if (rsl)
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
