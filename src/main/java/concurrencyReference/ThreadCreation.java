package concurrencyReference;

public class ThreadCreation {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("say hello");
        // thread needs a runnable
        Runnable runthis = new Runnable() {
            @Override
            public void run() {
                System.out.println("Saying hello from thread");
            }
        };

        //creating thread by runnable
        Thread t1 = new Thread(runthis);
        //running thread
        t1.start();
        // fetching thread name
        System.out.println("thread name : " + t1.getName());
        //fetching thread state
        System.out.println("Thread state: " + t1.getState());
        // making thread sleep
        t1.sleep(10000);
        System.out.println("threat waited...");
        //fetching thread state again
        System.out.println("Thread state: " + t1.getState());
    }
}
