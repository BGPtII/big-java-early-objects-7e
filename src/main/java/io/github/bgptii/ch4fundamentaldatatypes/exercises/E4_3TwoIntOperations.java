package io.github.bgptii.ch4fundamentaldatatypes.exercises;

import java.util.Scanner;

public class E4_3TwoIntOperations {

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
        System.out.println("Sum: " + (a + b));
        System.out.println("Difference: " + (a - b));
        System.out.println("Product: " + (a * b));
        System.out.println("Average: " + ((a + b) / 2.0));
        System.out.println("Distance: " + Math.abs(a - b));
        System.out.println("Maximum: " + Math.max(a, b));
        System.out.println("Minimum: " + Math.min(a, b));
    }

}
