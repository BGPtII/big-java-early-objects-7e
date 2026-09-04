package io.github.bgptii.ch4fundamentaldatatypes.projects;

import java.util.Scanner;

public class P4_3Puzzle1089 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (!in.hasNextInt()) {
            System.out.println("Not an integer.");
            return;
        }
        int i = Math.abs(in.nextInt() % 1000); // Keep last 3 digits
        System.out.println("Input: " + i);
        int reversed = reverse(i);
        System.out.println("Reversed: " + reversed);
        int difference = Math.abs(i - reversed);
        System.out.println("Difference: " + difference);
        int reversedDifference = reverse(difference);
        System.out.println("Reversed: " + reversedDifference);
        System.out.println("Sum: " + (difference + reversedDifference));
    }

    private static int reverse(int i) {
        int hundreds = i / 100;
        i = i % 100;
        int tens = i / 10;
        i = i % 10;
        return (i * 100) + (tens * 10) + hundreds;
    }

}
