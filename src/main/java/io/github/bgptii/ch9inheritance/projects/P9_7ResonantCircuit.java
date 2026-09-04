package io.github.bgptii.ch9inheritance.projects;

public abstract class P9_7ResonantCircuit {

    private double resonantFrequency;
    private double bandwidth;
    private double gainAtResonantFrequency;

    public P9_7ResonantCircuit(double resonantFrequency, double bandwidth, double gainAtResonantFrequency) {
        setResonantFrequency(resonantFrequency);
        setBandwidth(bandwidth);
        setGainAtResonantFrequency(gainAtResonantFrequency);
    }

    public double getResonantFrequency() {
        return resonantFrequency;
    }

    public void setResonantFrequency(double resonantFrequency) {
        if (resonantFrequency <= 0) {
            throw new IllegalArgumentException("Resonant frequency must be greater than 0");
        }
        this.resonantFrequency = resonantFrequency;
    }

    public double getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(double bandwidth) {
        if (bandwidth <= 0) {
            throw new IllegalArgumentException("Bandwidth must be greater than 0");
        }
        this.bandwidth = bandwidth;
    }

    public double getGainAtResonantFrequency() {
        return gainAtResonantFrequency;
    }

    public void setGainAtResonantFrequency(double gainAtResonantFrequency) {
        if (gainAtResonantFrequency <= 0) {
            throw new IllegalArgumentException("Gain at resonant frequency must be greater than 0");
        }
        this.gainAtResonantFrequency = gainAtResonantFrequency;
    }

    public void display() {
        System.out.println("Resonant frequency: " + resonantFrequency);
        System.out.println("Bandwidth: " + bandwidth);
        System.out.println("Gain at resonance frequency: " + gainAtResonantFrequency);
    }

    public abstract void design();

}
