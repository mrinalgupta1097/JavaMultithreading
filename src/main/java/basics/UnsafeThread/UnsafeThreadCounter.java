package basics.UnsafeThread;

public class UnsafeThreadCounter {

    public static int count = 0;
    public static void increment(){
        count++;
    }
    public static void decrement(){
        count--;
    }

    public static void printFinalCountValue(){
        System.out.println("Final count is: " + count);
    }

}
