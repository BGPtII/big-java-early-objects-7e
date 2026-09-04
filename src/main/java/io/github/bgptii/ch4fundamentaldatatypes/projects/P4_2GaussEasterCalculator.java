package io.github.bgptii.ch4fundamentaldatatypes.projects;

import java.util.Scanner;

/**
 * Easter Sunday is the first Sunday after the first full moon of spring. To compute
 * the date, you can use this algorithm, invented by the mathematician Carl Friedrich
 * Gauss in 1800.
 */
public class P4_2GaussEasterCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y;
        System.out.print("Enter a year: ");
        if (!in.hasNextInt()) {
            System.out.println("Not an integer.");
            return;
        }
        y = in.nextInt();
        int a = y % 19;
        int b = y / 100;
        int c = y % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        int n = (h - m + r + 90) / 25;
        int p = (h - m + r + n + 19) % 32;
        System.out.println("Easter Sunday fell on day " + p + " of month " + n);
    }

}
