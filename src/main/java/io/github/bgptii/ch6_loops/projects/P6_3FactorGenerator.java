package io.github.bgptii.ch6_loops.projects;

/**
 * Asks the user for an integer and then prints out all its factors. For example, when the user enters
 * 150, the program should print 2 3 5 5.
 */
public class P6_3FactorGenerator {

    private int numberToFactor;
    private int nextNumber;

    P6_3FactorGenerator(int numberToFactor) {
        if (numberToFactor < 1) {
            throw new IllegalArgumentException("Number must be > 0");
        }
        this.numberToFactor = numberToFactor;
        this.nextNumber = 2;
    }

    public int nextFactor() {
        while (numberToFactor % nextNumber != 0) {
            nextNumber++;
        }
        numberToFactor /= nextNumber;
        return nextNumber;
    }

    public boolean hasMoreFactors() {
        return numberToFactor > 1;
    }

}
