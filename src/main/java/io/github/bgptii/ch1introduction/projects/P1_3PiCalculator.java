package io.github.bgptii.ch1introduction.projects;

/**
 * Write an algorithm to compute π. Because the formula is an infinite series and an
 * algorithm must stop after a finite number of steps, you should stop when you have
 * the result determined to six significant digits.
 * Formula: (pi/4) = 1 - 1/3 + 1/5 + 1/7 + 1/9
 */
public class P1_3PiCalculator {

    public static void main(String[] args) {
        double sum = 0;
        double denominator = 1;
        double sign = 1;
        /*
        Six significant digits for pi requires accuracy to the 0.00001 place,
        half of that value (0.000005) is used as the tolerance so the result
        rounds correctly to six significant digits.
         */
        double tolerance = 0.000005;

        while (4.0 / denominator <= tolerance) {
            sum += sign / denominator;
            denominator += 2;
            sign = -sign;
        }

        System.out.println("Sum: " + sum);
    }
}
