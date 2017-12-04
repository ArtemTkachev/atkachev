package ru.job4j;

public class CycleList<T> {
    private Node<Integer> first;

    public Node<Integer> getFirst() {
        return first;
    }

    class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public void createNodesForCycleOne() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        this.first = first;
    }

    public void createNodesForCycleTwo() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;

        this.first = first;
    }

    public void createNodesForCycleNo() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;

        this.first = first;
    }

    public boolean hasCycle(Node<T> first) {
        boolean hC = false;
        int step = 1;
        Node<T> el = first, elIn;
        Node<T> elNext;
        while (!hC) {
            elNext = el.next;
            if (elNext == null) {
                break;
            }
            elIn = first;
            for (int i = 1; i <= step; i++) {
                if (elNext == elIn && elNext != null) {
                    hC = true;
                    break;
                }
                elIn = elIn.next;
            }
            if (hC)
                break;
            el = elNext;
            step++;
        }
        return hC;
    }

}
