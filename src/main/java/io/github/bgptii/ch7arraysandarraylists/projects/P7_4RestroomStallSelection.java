package io.github.bgptii.ch7arraysandarraylists.projects;

import java.util.Scanner;

/**
 * Reads the number of stalls and then prints out diagrams in the
 * format given above when the stalls become filled, one at a time.
 */
public class P7_4RestroomStallSelection {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many stalls in a contiguous line: ");
        int stalls;
        if (!in.hasNextInt() || (stalls = in.nextInt()) < 1 || stalls > 100) {
            System.out.println("Not a valid integer. Needs to be: 0 < n < 100");
            return;
        }
        boolean[] occupiedStalls = new boolean[stalls];
        boolean moreStalls = true;
        while (moreStalls) {
            int startI = -1;
            int longestStartI = -1;
            int longestLength = -1;
            for (int i = 0; i < stalls; i++) {
                if (startI == -1 && !occupiedStalls[i]) {
                    startI = i;
                }
                if (startI != -1 && occupiedStalls[i]) {
                    int length = i - startI;
                    if (length > longestLength) {
                        longestLength = length;
                        longestStartI = startI;
                    }
                    startI = -1;
                }
            }
            if (startI != -1) {
                int length = stalls - startI;
                if (length > longestLength) {
                    longestLength = length;
                    longestStartI = startI;
                }
            }
            if (longestLength > 0) {
                occupiedStalls[longestStartI + longestLength / 2] = true;
                for (boolean occupiedStall : occupiedStalls) {
                    System.out.print("[" + (occupiedStall ? "x" : " ") + "] ");
                }
                System.out.println();
            }
            else {
                moreStalls = false;
            }
        }

    }

}
