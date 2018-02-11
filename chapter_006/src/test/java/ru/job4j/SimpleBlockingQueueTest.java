package ru.job4j;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleBlockingQueueTest {

    private class ThreadProducer extends Thread {
        private final SimpleBlockingQueue<Integer> simpleBlockingQueue;

        public ThreadProducer(SimpleBlockingQueue<Integer> simpleBlockingQueue) {
            this.simpleBlockingQueue = simpleBlockingQueue;
        }

        @Override
        public void run() {
            try {
                this.simpleBlockingQueue.offer(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private class ThreadConsumer extends Thread {
        private final SimpleBlockingQueue<Integer> simpleBlockingQueue;
        private Integer result;

        public ThreadConsumer(SimpleBlockingQueue<Integer> simpleBlockingQueue) {
            this.simpleBlockingQueue = simpleBlockingQueue;
        }

        public Integer getResult() {
            return this.result;
        }
        @Override
        public void run() {
            try {
                this.result = this.simpleBlockingQueue.peek();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void whenExecute2ThreadThenTrue() throws InterruptedException {
        SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>();
        Thread prod = new ThreadProducer(simpleBlockingQueue);
        Thread cons = new ThreadConsumer(simpleBlockingQueue);
        prod.start();
        prod.join();
        cons.start();
        cons.join();
        ThreadConsumer cons2 = (ThreadConsumer)cons;
        assertThat(cons2.getResult(),is(10));


    }
}
