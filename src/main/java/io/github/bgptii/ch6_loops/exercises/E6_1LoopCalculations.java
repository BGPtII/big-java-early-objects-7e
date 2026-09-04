package io.github.bgptii.ch6_loops.exercises;

import java.util.Scanner;

public class E6_1LoopCalculations {
    public static void main(String[] args) {
        int a = 0; // All even numbers between 2 and 100 (inclusive)
        for (int i = 2; i < 101; i += 2) {
            a += i;
        }
        System.out.println("The sum of all even numbers between 2 and 100 (inclusive) is " + a);

        int b = 0; // Sum of all squares between 1 and 100 (inclusive)
        for (int i = 1; i < 101; i *= 2) {
            b += i;
        }
        System.out.println("The sum of all squares between 1 and 100 (inclusive) is " + b);

        System.out.println("All powers of 2 from 2^0 up to 2^20...");
        for (int i = 0; i < 21; i++) {
            System.out.println("2^" + i + ": " + (int) Math.pow(2, i));
        }

        int d = 0; // Sum of all odd numbers between a & b (inclusive), where a and b are inputs
        Scanner in = new Scanner(System.in);
        System.out.print("Enter integer a: ");
        if (!in.hasNextInt()) {
            System.out.println("Not an integer.");
            return;
        }
        a = in.nextInt();
        System.out.print("Enter integer b: ");
        if (!in.hasNextInt()) {
            System.out.println("Not an integer.");
            return;
        }
        b = in.nextInt();
        int smallest = Math.min(a, b);
        int biggest = Math.max(a, b);
        for (int i = smallest; i <= biggest; i++) {
            if (i % 2 != 0) {
                d += i;
            }
        }
        System.out.println("The sum of all odd numbers between " + smallest + " and " + biggest + " is " + d);

        int e = 0; // The sum of all odd digits of an input (EX: 32677 > 3 + 7 + 7
        System.out.print("Enter an integer: ");
        if (!in.hasNextInt()) {
            System.out.println("Not an integer.");
            return;
        }
        int input = Math.abs(in.nextInt());
        while (input != 0) {
            int remainder = input % 10;
            if (remainder % 2 != 0) {
                e += remainder;
            }
            input /= 10;
        }
        System.out.println("Sum of all odd digits of " + input + " is " + e);
    }
}
