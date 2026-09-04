package io.github.bgptii.ch9inheritance.projects;

public class P9_7ParallelResonantCircuit extends P9_7ResonantCircuit {

    private double resistance;
    private double capacitance;
    private double inductance;

    public P9_7ParallelResonantCircuit(double resonantFrequency, double bandWidth, double gainAtResonantFrequency) {
        super(resonantFrequency, bandWidth, gainAtResonantFrequency);
    }

    @Override
    public void design() {
        resistance = getGainAtResonantFrequency();
        capacitance = 1 / (getBandwidth() * resistance);
        inductance = 1 / (Math.pow(getResonantFrequency(), 2) * capacitance);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Resistance: " + resistance);
        System.out.println("Capacitance: " + capacitance);
        System.out.println("Inductance: " + inductance);
    }

}
