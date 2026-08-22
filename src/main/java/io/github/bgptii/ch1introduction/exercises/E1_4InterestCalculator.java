package io.github.bgptii.ch1introduction.exercises;

/**
 * Compounding interest formula: FV=PV(1+r)^n
 * PV = starting balance
 * r = annual interest rate
 * n = number of years
 * Prints the balance of an account after the first, second, and
 * third year. The account has an initial balance of $1,000 and earns 5 percent interest
 * per year.
 */
public class E1_4InterestCalculator {

    public static void main(String[] args) {
        System.out.println(1000 * Math.pow((1 + 0.05), 5));
    }

}
