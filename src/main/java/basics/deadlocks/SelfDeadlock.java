package basics.deadlocks;

public class SelfDeadlock {
    boolean isLocked;

    public SelfDeadlock() {
    }

    public SelfDeadlock(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            wait();// asks current thread until notified or interrupted
        }
        isLocked= true;
    }

    public synchronized void unlock(){
        isLocked = false;
        notify(); // notify threads waiting to resume
    }

}
