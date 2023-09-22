package basics.deadlocks;

public class SelfDeadlockRunner {
    public static void main(String[] args) throws InterruptedException {
        SelfDeadlock sl = new SelfDeadlock();
        // First locking would be successful
        sl.lock();
        System.out.println("Acquired first lock");

        // Second locking results in a self deadlock
        System.out.println("Trying to acquire second lock");
        sl.lock();
        System.out.println("Acquired second lock");

    }
}
