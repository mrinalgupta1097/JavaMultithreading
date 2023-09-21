package basics.raceConditions;

import java.util.Random;

public class RaceCondition {
    static int randomInt;
    static Random random = new Random(System.currentTimeMillis());

    static void printer(){
        int i = 1000000;
        while (i != 0) {
            if (randomInt % 5 == 0) {
                if (randomInt % 5 != 0)
                    System.out.println(randomInt);
            }
            i--;
        }
    }

    static void modifier(){
        int i = 1000000;
        while(i != 0){
            randomInt = random.nextInt(1000);
            i--;
        }
    }

    public static void runTest() throws InterruptedException {
        Thread t1 = new Thread(() -> RaceCondition.printer());
        Thread t2 = new Thread(() -> RaceCondition.modifier());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
