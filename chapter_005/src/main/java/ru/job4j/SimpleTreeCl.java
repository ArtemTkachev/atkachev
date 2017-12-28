package ru.job4j;

import java.util.*;

public class SimpleTreeCl<E extends Comparable<E>> implements SimpleTree<E> {
    private final Node<E> root;

    public SimpleTreeCl(E value) {
        root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> resParent = this.findBy(parent);
        if (resParent.isPresent()) {
            if (!this.findBy(child).isPresent()) {
                Node<E> parentNode = resParent.get();
                parentNode.add(new Node<>(child));
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
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

    public boolean isBinary() {
        boolean rsl = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                rsl = false;
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> ownEl = root;

            private E returnNext(String func) {
                E result = null;
                if (ownEl != null) {
                    boolean nFlag = false;
                    Queue<Node<E>> data = new LinkedList<>();
                    data.offer(root);
                    while (!data.isEmpty()) {
                        Node<E> el = data.poll();
                        if (nFlag) {
                            ownEl = el;
                            nFlag = false;
                            break;
                        }
                        if (el.compareTo(ownEl)) {
                            result = el.getValue();
                            if (func.equals("hN"))
                                break;
                            nFlag = true;
                        }
                        for (Node<E> child : el.leaves()) {
                            data.offer(child);
                        }
                    }
                    if (nFlag) {
                        ownEl = null;
                    }
                }
                return result;
            }

            @Override
            public boolean hasNext() {
                return returnNext("hN") != null;
            }

            @Override
            public E next() {
                E value = returnNext("n");
                if (value != null) {
                    return value;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
