package io.github.bgptii.ch10interfaces.projects;

public class P10_5FirstDigitDistribution {

    private final int[] counters;

    public P10_5FirstDigitDistribution() {
        counters = new int[10];
    }

    public void process(P10_4Sequence seq, int valuesToProcess) {
        for (int i = 1; i <= valuesToProcess; i++) {
            int value = seq.next();
            while (value >= 10) {
                value /= 10;
            }
            counters[value]++;
        }
    }

    public void display() {
        for (int i = 0; i < counters.length; i++) {
            System.out.println(i + ": " + counters[i]);
        }
    }

}
