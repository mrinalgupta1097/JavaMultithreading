package basics.UnsafeThread;

import java.util.Random;

public class ThreadUnsafeDemo {
    //    use this to randomly sleep the threads
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        // create thread for increment
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                UnsafeThreadCounter.increment();
                ThreadUnsafeDemo.sleepRandomlyForLessThan10Secs();

            }
        });

        // create second thread for decrement
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                UnsafeThreadCounter.decrement();
                ThreadUnsafeDemo.sleepRandomlyForLessThan10Secs();

            }
        });

        // run both threads
        t1.start();
        t2.start();

        // wait for t1 and t2 to complete.
        t1.join();
        t2.join();

        // print final value of counter
        UnsafeThreadCounter.printFinalCountValue();
    }

    public static void sleepRandomlyForLessThan10Secs() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
        }
    }

}
