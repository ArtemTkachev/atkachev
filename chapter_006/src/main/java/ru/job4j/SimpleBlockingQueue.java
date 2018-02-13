package ru.job4j;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<E> {
    private Queue<E> queue = new LinkedList<>();
    private final Integer maxSize = 10;
    private Integer size = 0;
    private final Object lock = new Object();

    public Integer getSize() {
        return size;
    }

    public void offer(E value) throws InterruptedException {
        synchronized(this.lock) {
                while (maxSize <= this.size) {
                    lock.wait();
                }

                queue.offer(value);
                this.size++;
                lock.notify();

        }
    }

    public E peek() throws InterruptedException {
        synchronized(this.lock) {
                while (0 >= this.size) {
                    lock.wait();
                }

                E value = queue.peek();
                this.size--;
                lock.notify();
                return value;
            }
    }

}
