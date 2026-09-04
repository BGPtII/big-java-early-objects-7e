package io.github.bgptii.ch2usingobjects.projects;

import java.util.Arrays;
import java.util.Random;

/**
 * Write a program LotteryPrinter that picks a combination
 * in a lottery. In this lottery, players can choose 6 numbers (possibly repeated) between 1 and 49.
 */
public class P2_7LotteryPrinter {

    public static void main(String[] args) {
        Random r = new Random();
        int[] opts = new int[6];
        for (int i = 0; i < 6; i++) {
            opts[i] = r.nextInt(49) + 1;
        }
        System.out.println("Play this combination — it'll make you rich! " + Arrays.toString(opts));
    }

}
