package io.github.bgptii.ch4fundamentaldatatypes.exercises;

import java.util.Scanner;

/**
 * Reads a number and displays the square, cube, and fourth
 * power. Use the Math.pow method only for the fourth power
 */
public class E4_2UserNumberPowers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        if (in.hasNextDouble()) {
            double d = in.nextDouble();
            System.out.println("Squared: " + Math.pow(d, 2));
            System.out.println("Cubed: " + Math.pow(d, 3));
            System.out.println("Fourth power: " + Math.pow(d, 4));
        }
        else {
            System.out.println("Not a number");
        }
    }

}
