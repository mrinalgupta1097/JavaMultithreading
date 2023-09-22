package basics.deadlocks;

public class DeadlockDemonstration {
    public static void main(String[] args) throws InterruptedException {
        Deadlock deadlock = new Deadlock();
        deadlock.runTest();
    }
}
