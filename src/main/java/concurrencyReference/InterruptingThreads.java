package concurrencyReference;

public class InterruptingThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread innerThread = new Thread(() ->{
            try{
                System.out.println("inner thread goes to sleep at " + System.currentTimeMillis()/1000);
                Thread.sleep(1000*1000);
            } catch (InterruptedException e) {
                System.out.println("innerThread interrupted at " + System.currentTimeMillis()/1000);
            }
        });

        innerThread.start();
        // Interrupt innerThread after waiting for 5 seconds
        System.out.println("Main thread sleeping at " + +System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        innerThread.interrupt();
        System.out.println("Main thread exiting at " + +System.currentTimeMillis() / 1000);
    }
}
