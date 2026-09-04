package io.github.bgptii.ch7arraysandarraylists.projects;

import java.util.Random;

/**
 * Generates a sequence of 20 random die tosses in an array and that prints the die values, marking
 * the runs by including them in parentheses
 */
public class P7_2DieRunMarker {

    public static void main(String[] args) {
        Random r = new Random();
        int[] values = new int[20];
        for (int i = 0; i < 20; i++) {
            values[i] = r.nextInt(6) + 1;
        }
        boolean inRun = false;
        for (int i = 0; i < values.length; i++) {
            if (inRun) {
                if (values[i] != values[i - 1]) {
                    System.out.print(")");
                    inRun = false;
                }
            }
            if (i > 0) {
                System.out.print(" ");
            }
            if (!inRun && i + 1 != values.length) {
                if (values[i] == values[i + 1]) {
                    System.out.print("(");
                    inRun = true;
                }
            }
            System.out.print(values[i]);
        }
        if (inRun) {
            System.out.print(")");
        }

    }

}
