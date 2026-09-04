package io.github.bgptii.ch8designingclasses.projects;

import java.util.Map;
import java.util.Random;

public class P8_14Resistor {

    private final double nominalResistance;
    private final double tolerance;
    private final double actualResistance;
    private static final Random RANDOM = new Random();
    private static final String[] NOMINAL_RESISTANCE_BANDS = new String[] {
            "Black",
            "Brown",
            "Red",
            "Orange",
            "Yellow",
            "Green",
            "Blue",
            "Violet",
            "Gray",
            "White"
    };
    private static final Map<Double, String> TOLERANCE_BANDS = Map.of(
            1.0, "Brown",
            2.0, "Red",
            0.5, "Green",
            0.25, "Blue",
            0.1, "Violet",
            0.05, "Gray",
            5.0, "Gold",
            10.0, "Silver",
            20.0, "None"
    );

    public P8_14Resistor(double nominalResistance, double tolerance) {
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

    private int[] getNominalResistanceIndexes() {
        double nominalResistanceCopy = nominalResistance;
        int multiplier = 0;
        while (nominalResistanceCopy >= 100) {
            nominalResistanceCopy /= 10;
            multiplier++;
        }
        while (nominalResistanceCopy < 10) {
            nominalResistanceCopy *= 10;
            multiplier--;
        }
        return new int[] { (int) (nominalResistanceCopy / 10), (int) (nominalResistanceCopy % 10), multiplier };
    }

    private String getToleranceBand() {
        if (!TOLERANCE_BANDS.containsKey(tolerance)) {
            throw new IllegalArgumentException("Invalid tolerance. Allowed values: 0.05%, 0.1%, 0.25%, 0.5%, 1%, 2%, 5%, 10%, and 20%");
        }
        return TOLERANCE_BANDS.get(tolerance);
    }

    public String[] getColourBands() {
        int[] nominalResistanceIndexes = getNominalResistanceIndexes();
        int multiplier = nominalResistanceIndexes[2];
        String multiplierBand;
        if (multiplier == -2) {
            multiplierBand = "Silver";
        }
        else if (multiplier == -1) {
            multiplierBand = "Gold";
        }
        else {
            multiplierBand = NOMINAL_RESISTANCE_BANDS[multiplier];
        }
        return new String[] { NOMINAL_RESISTANCE_BANDS[nominalResistanceIndexes[0]],
                NOMINAL_RESISTANCE_BANDS[nominalResistanceIndexes[1]],
                multiplierBand,
                getToleranceBand()
        };
    }

}

