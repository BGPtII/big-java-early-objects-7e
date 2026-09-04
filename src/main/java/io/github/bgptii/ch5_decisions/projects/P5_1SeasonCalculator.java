package io.github.bgptii.ch5_decisions.projects;

import java.util.Scanner;

public class P5_1SeasonCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a month (1-12 inclusive): ");
        int m;
        if (!in.hasNextInt() || (m = in.nextInt()) < 1 || m > 12) {
            System.out.println("Month must be an integer between 1 and 12 inclusive.");
            return;
        }
        int d;
        System.out.print("Enter a day (1-31 inclusive): ");
        if (!in.hasNextInt() || (d = in.nextInt()) < 1 || d > 31) {
            System.out.println("Day must be an integer between 1 and 31 inclusive.");
            return;
        }
        System.out.println("Season: " + new P5_1Date(m, d).getSeason());
    }

}
