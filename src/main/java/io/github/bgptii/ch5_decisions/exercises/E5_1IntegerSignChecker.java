package io.github.bgptii.ch5_decisions.exercises;

import java.util.Scanner;

public class E5_1IntegerSignChecker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (!in.hasNextInt()) {
            System.out.println("Not an integer.");
            return;
        }
        int i = in.nextInt();
        if (i > 0) {
            System.out.println("Integer is positive.");
        }
        else if (i < 0) {
            System.out.println("Integer is negative.");
        }
        else {
            System.out.println("Integer is zero.");
        }
    }

}
