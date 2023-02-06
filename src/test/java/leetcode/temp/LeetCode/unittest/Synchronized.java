package leetcode.temp.LeetCode.unittest;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Synchronized {
    private final static int NUM_THREADS = 100;
    private final static int NUM_ITERATIONS = 1000;

    @Test
    void testSynchronized() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        final Counter sync = new Counter();
        final Counter notSync = new Counter();

//        Long start = CurrentTimeUtils.getCurrentTime();
//        Thread.sleep(5000);
//        Long usedTime = CurrentTimeUtils.getCurrentTime() - start;
//        System.out.println("usedTime - " + usedTime);
        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(() -> {
                for (int j = 0; j < NUM_ITERATIONS; j++) {
                    sync.incSync();
                    notSync.inc();
                }
            });
        }
        executor.shutdown();

        System.out.println("sync - " + sync.getValue());
        System.out.println("notSync - " + notSync.getValue());
        assertEquals(sync.getValue(), NUM_THREADS * NUM_ITERATIONS);
        assertNotEquals(notSync.getValue(), NUM_THREADS * NUM_ITERATIONS);
    }

    @Test
    void testSynchronized2() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Counter counter = new Counter();
        Counter counter2 = new Counter();

        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(()->{
                for (int j=0; j<NUM_ITERATIONS;j++) {
                    counter.inc();
                    counter2.incSync();
                }
            });
        }
    }

    static class Counter {
        private int value = 0;

        public synchronized void incSync() {
            value++;
        }

        public void inc() {
            value++;
        }

        public int getValue() {
            return value;
        }
    }

    class Test2 {

    }

    class Counter2 {
        private Test2 value = null;

        public synchronized void incSync() {
            if (value == null) {
                this.value = new Test2();
            }
        }

        public void inc() {
            if (value == null) {
                this.value = new Test2();
            }
        }

        public Test2 getValue() {
            return value;
        }
    }
}
