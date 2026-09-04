package io.github.bgptii.ch7arraysandarraylists.exercises;

import java.util.Scanner;

public class E7_1TenNumberReverseOrder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter int #" + (i + 1) + ": ");
            if (!in.hasNextInt()) {
                System.out.println("Not an integer.");
                return;
            }
            input[i] = in.nextInt();
        }
        System.out.println("Numbers in reverse order:");
        for (int i = input.length - 1; i >= 0; i--) {
            System.out.print(" " + input[i]);
        }
    }
}
