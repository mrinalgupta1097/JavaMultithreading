package basics;

public class Sum {
    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_SUM = Integer.MAX_VALUE;

    public Sum(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {
        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    static void oneThread() {
        long start = System.currentTimeMillis();
        Sum sum = new Sum(1, MAX_SUM);
        sum.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + sum.counter + " took " + (end - start));
    }

    static void twoThreads() throws InterruptedException {
        long start = System.currentTimeMillis();
        Sum s1 = new Sum(1, MAX_SUM / 2);
        Sum s2 = new Sum((1 + (MAX_SUM / 2)), MAX_SUM);
        Thread t1 = new Thread(s1::add);
        Thread t2 = new Thread(s2::add);

        t1.start();
        t2.start();

        t1.join();  // wait for t1 to complete
        t2.join();  // wait for t2 to complete

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }

    public static void runTest() throws InterruptedException {
        oneThread();
        twoThreads();
    }
}
