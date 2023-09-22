package basics.raceConditions;

import java.util.Random;

public class RaceConditionSolved {

    int randomInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {
        int i = 1000000;
        while (i != 0) {
            synchronized (this) {
                if (randomInt % 5 == 0) {
                    if(randomInt % 5 != 0){
                        System.out.println(randomInt);
                    }
                }
            }
            i--;
        }
    }

    void modifier(){
        int i = 1000000;
        while(i != 0){
            synchronized (this){
                randomInt = random.nextInt(1000);
                i--;
            }
        }
    }

    public static void runTest() throws InterruptedException {


        final RaceConditionSolved rc = new RaceConditionSolved();
        Thread thread1 = new Thread(rc::printer);
        Thread thread2 = new Thread(rc::modifier);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
