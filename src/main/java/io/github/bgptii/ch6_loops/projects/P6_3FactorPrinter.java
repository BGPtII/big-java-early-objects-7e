package io.github.bgptii.ch6_loops.projects;

import java.util.Scanner;

public class P6_3FactorPrinter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer > 1: ");
        int i;
        if (!in.hasNextInt() || (i = in.nextInt()) < 2) {
            System.out.println("Not a valid integer");
            return;
        }
        P6_3FactorGenerator generator = new P6_3FactorGenerator(i);
        System.out.println("Factors:");
        while (generator.hasMoreFactors()) {
            System.out.print(generator.nextFactor() + " ");
        }
    }

}
