package ru.job4j;

public abstract class StackQueueContainer<E> {
    protected SimpleLinkList<E> simpleLinkList;

    public StackQueueContainer() {
        this.simpleLinkList = new SimpleLinkList<>();
    }

    public abstract E poll();

    public void push(E value) {
        if (simpleLinkList.getSize() > 0) {
            simpleLinkList.add(simpleLinkList.get(simpleLinkList.getSize() - 1));
            if (simpleLinkList.getSize() > 2) {
                for (int i = simpleLinkList.getSize() - 2; i > 0; i--) {
                    simpleLinkList.set(i, simpleLinkList.get(i - 1));
                }
            }
            simpleLinkList.set(0, value);
        } else {
            simpleLinkList.add(value);
        }
    }
}
