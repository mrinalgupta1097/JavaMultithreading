package basics.raceConditions;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        RaceCondition.runTest();
        System.out.println("Race condition solved");
        RaceConditionSolved.runTest();
    }
}
