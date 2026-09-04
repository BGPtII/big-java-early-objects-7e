package io.github.bgptii.ch7arraysandarraylists.projects;

import java.util.Random;

public class P7_3LongestDieRun {

    public static void main(String[] args) {
        Random r = new Random();
        int[] values = new int[20];
        for (int i = 0; i < 20; i++) {
            values[i] = r.nextInt(6) + 1;
        }

        int longestStart = -1;
        int longestLength = -1;
        int currentStart = -1;
        int currentLength;

        for (int i = 0; i < 20; i++) {
            if (currentStart != -1) {
                if (values[i] != values[i - 1]) {
                    currentLength = i - currentStart;
                    if (currentLength > longestLength) {
                        longestLength = currentLength;
                        longestStart = currentStart;
                    }
                    currentStart = -1;
                }
            }
            if (currentStart == -1 && i + 1 != values.length) {
                if (values[i] == values[i + 1]) {
                    currentStart = i;
                }
            }
        }
        if (currentStart != -1) {
            currentLength = values.length - 1 - currentStart;
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestStart = currentStart;
            }
        }
        for (int i = 0; i < values.length; i++) {
            if (longestLength != -1 && i == longestStart) {
                System.out.print("(");
            }
            System.out.print(values[i]);
            if (i == longestStart + longestLength - 1) {
                System.out.print(")");
            }
            System.out.print(" ");
        }
    }

}
