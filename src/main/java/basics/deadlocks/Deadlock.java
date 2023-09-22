package basics.deadlocks;

public class Deadlock {
    private int counter = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    Runnable incrementer = () -> {
        try {
            for (int i = 0; i < 100; i++) {
                incrementCounter();
                System.out.println("Incrementing " + i);
            }
        } catch (InterruptedException ie) {
        }
    };

    private void incrementCounter() throws InterruptedException {
        synchronized (lock1) {
            System.out.println("Acquired lock1");
            Thread.sleep(100);

            synchronized (lock2) {
                counter++;
            }
        }
    }

    Runnable decrementer = () -> {
        try {
            for (int i = 0; i < 100; i++) {
                decrementCounter();
                System.out.println("Decrementing " + i);
            }
        } catch (InterruptedException ie) {

        }
    };

    private void decrementCounter() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("Acquired lock2");
            Thread.sleep(100);
            synchronized (lock1) {
                counter--;
            }
        }
    }

    public void runTest() throws InterruptedException {
        Thread t1 = new Thread(incrementer);
        Thread t2 = new Thread(decrementer);

        t1.start();
        Thread.sleep(100); // sleep to make sure 1 gets a chance to acquire lock1
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Done : " + counter);
    }


}
