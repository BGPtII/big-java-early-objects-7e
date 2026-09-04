package io.github.bgptii.ch8designingclasses.projects;

import java.util.Random;

public class P8_13Resistor {

    private final double nominalResistance;
    private final double tolerance;
    private final double actualResistance;
    private static final Random RANDOM = new Random();

    public P8_13Resistor(double nominalResistance, double tolerance) {
        if (nominalResistance <= 0) {
            throw new IllegalArgumentException("Nominal resistance must be greater than 0");
        }
        if (tolerance <= 0) {
            throw new IllegalArgumentException("Tolerance must be between 0 and 100%");
        }
        this.nominalResistance = nominalResistance;
        this.tolerance = tolerance;
        double diff = nominalResistance * (tolerance / 100);
        double maximum = nominalResistance + diff;
        double minimum = nominalResistance - diff;
        actualResistance = RANDOM.nextDouble() * (maximum - minimum) + minimum;
    }

    public double getNominalResistance() {
        return nominalResistance;
    }

    public double getTolerance() {
        return tolerance;
    }

    public double getActualResistance() {
        return actualResistance;
    }

}
