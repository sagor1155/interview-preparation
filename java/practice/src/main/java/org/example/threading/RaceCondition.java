package org.example.threading;


class Counter {
    public int count;

    // thread safe with 'synchronized' keyword
    public synchronized void increment() {
        count++;
    }

}

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable ra = () -> {
            for (int i=0; i<1000; i++) {
                counter.increment();
//                Thread current = Thread.currentThread();
//                System.out.println(current.getName());
            }
        };
        Runnable rb = () -> {
            for (int i=0; i<1000; i++) {
                counter.increment();
//                Thread current = Thread.currentThread();
//                System.out.println(current.getName());
            }
        };

        // create thread (STATE: NEW)
        Thread ta = new Thread(ra, "Thread-A");
        Thread tb = new Thread(rb, "Thread-B");

        // set priority
        ta.setPriority(Thread.MAX_PRIORITY);
        tb.setPriority(Thread.MIN_PRIORITY);

        // thread start (STATE: RUNNABLE)
        ta.start();
        tb.start();

        System.out.println(ta.getName() + " State: " + ta.getState());
        System.out.println(ta.getName() + " isAlive: " + ta.isAlive());
        Thread current = Thread.currentThread();
        System.out.println("Current thread: " + current.getName());

        // main thread will wait for these threads to be completed/terminated
        ta.join();
        tb.join();

        System.out.println("Counter: " + counter.count);
        System.out.println(ta.getName() + " State: " + ta.getState());
        System.out.println(ta.getName() + " isAlive: " + ta.isAlive());
    }
}
