package io.github.bgptii.ch8designingclasses.projects;

public class P8_15VoltageDivider {

    private final P8_13Resistor r1;
    private final P8_13Resistor r2;

    public P8_15VoltageDivider(double nominalResistanceR1, double nominalResistanceR2, double tolerance) {
        r1 = new P8_13Resistor(nominalResistanceR1, tolerance);
        r2 = new P8_13Resistor(nominalResistanceR2, tolerance);
    }

    public double getNominalGain() {
        return r2.getNominalResistance() / (r1.getNominalResistance() + r2.getNominalResistance());
    }

    public double getActualGain() {
        return r2.getActualResistance() / (r1.getActualResistance() + r2.getActualResistance());
    }

}
