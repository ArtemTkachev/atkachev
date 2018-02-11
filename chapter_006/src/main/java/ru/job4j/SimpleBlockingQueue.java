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
    private final Object lockProd = new Object();
    private final Object lockCons = new Object();

    public Integer getSize() {
        return size;
    }

    public void offer(E value) throws InterruptedException {
        synchronized(this.lockProd) {
            synchronized (this.lockCons) {
                while (maxSize <= this.size) {
                    lockProd.wait();
                }
                queue.offer(value);
                this.size++;
                lockCons.notify();
            }
        }
    }

    public E peek() throws InterruptedException {
        synchronized(this.lockCons) {
            synchronized (this.lockProd) {
                while (0 >= this.size) {
                    lockCons.wait();
                }
                E value = queue.peek();
                this.size--;
                lockProd.notify();
                return value;
            }
        }
    }

}
