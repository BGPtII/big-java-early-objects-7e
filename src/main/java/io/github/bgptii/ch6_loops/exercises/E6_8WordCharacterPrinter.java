package io.github.bgptii.ch6_loops.exercises;

import java.util.Scanner;

public class E6_8WordCharacterPrinter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String s = in.next().trim();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }

}
