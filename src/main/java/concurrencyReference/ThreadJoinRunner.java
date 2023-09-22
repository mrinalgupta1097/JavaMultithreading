package concurrencyReference;

public class ThreadJoinRunner {
    public static void main(String[] args) throws InterruptedException {
        Thread innerThread = new Thread(() -> {
            while (true) {
                System.out.println("keep saying hello.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //swallow interrupted exception
                }
            }
        });
        innerThread.setDaemon(true); // sets a thread as worker thread.
        innerThread.join(); // JVM will not spawn innerThread
        innerThread.start();
    }

    /*
     * No output will be observed as inner thread is worker thread.
     * JVM does not wait for worker threads to end their execution
     * Main thread exists after starting daemon threads as it has nothing to execute further
     * using join() makes the JVM to wait for execution of innerThread() to complete
     */
}
