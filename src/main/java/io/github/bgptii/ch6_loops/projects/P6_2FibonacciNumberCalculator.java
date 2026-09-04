package io.github.bgptii.ch6_loops.projects;

import java.util.Scanner;

public class P6_2FibonacciNumberCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer > 0: ");
        int input;
        if (!in.hasNextInt() || (input = in.nextInt()) < 1) {
            System.out.println("Not a valid integer (> 0)");
            return;
        }
        int f1 = 1;
        int f2 = 1;
        int fnew = 1;
        for (int i = 2; i < input; i++) {
            fnew = f1 + f2;
            f2 = f1;
            f1 = fnew;
        }
        System.out.println("Fibonacci number at position " + input + " is " + fnew);
    }
}
