package io.github.bgptii.ch9inheritance.projects;

public class P9_7ResonantCircuitDemo {

    public static void main(String[] args) {
        P9_7ParallelResonantCircuit parallel = new P9_7ParallelResonantCircuit(10000, 1000, 1000);
        P9_7SeriesResonantCircuit series = new P9_7SeriesResonantCircuit(10000, 1000, 0.1);

        parallel.design();
        series.design();

        System.out.println("Parallel Resonant Circuit:");
        parallel.display();

        System.out.println();

        System.out.println("Series Resonant Circuit:");
        series.display();
    }

}
