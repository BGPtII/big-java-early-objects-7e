package io.github.bgptii.ch7arraysandarraylists.exercises;

import java.util.Random;

public class E7_2RandomArrayOutput {

    public static void main(String[] args) {
        Random r = new Random();
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = r.nextInt();
        }
        System.out.println("Every number at an even index:");
        for (int i = 0; i < ints.length; i += 2) {
            System.out.print(" " + ints[i]);
        }
        System.out.println("\nEvery even number:");
        for (int i = 0; i < 10; i ++) {
            if (ints[i] % 2 == 0) {
                System.out.print(" " + ints[i]);
            }
        }
        System.out.println("\nAll elements in reverse order:");
        for (int i = ints.length - 1; i >= 0; i--) {
            System.out.print(" " + ints[i]);
        }
        System.out.println("\nFirst element: " + ints[0]);
        System.out.println("Last element: " + ints[ints.length - 1]);
    }
}
