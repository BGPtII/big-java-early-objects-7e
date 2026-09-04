package io.github.bgptii.ch4fundamentaldatatypes.exercises;

import java.util.Scanner;

public class E4_4TwoIntOperationsFormatted {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        System.out.print("Enter first integer: ");
        if (!in.hasNextInt()) {
            System.out.println("Not an integer.");
            return;
        }
        a = in.nextInt();
        System.out.print("Enter second integer: ");
        if (!in.hasNextInt()) {
            System.out.println("Not an integer.");
            return;
        }
        b = in.nextInt();
        System.out.printf("%-12s %10d%n", "Sum: ",  a + b);
        System.out.printf("%-12s %10d%n", "Difference: ", a - b);
        System.out.printf("%-12s %10d%n", "Product: ", a * b);
        System.out.printf("%-12s %10.2f%n", "Average: ", (a + b) / 2.0);
        System.out.printf("%-12s %10d%n", "Distance: ", Math.abs(a - b));
        System.out.printf("%-12s %10d%n", "Maximum: ", Math.max(a, b));
        System.out.printf("%-12s %10d%n", "Minimum: ", Math.min(a, b));
    }

}
