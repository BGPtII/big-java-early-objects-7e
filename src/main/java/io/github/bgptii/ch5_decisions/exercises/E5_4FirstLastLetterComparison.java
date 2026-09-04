package io.github.bgptii.ch5_decisions.exercises;

import java.util.Scanner;

public class E5_4FirstLastLetterComparison {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String s = in.nextLine().toLowerCase();
        if (s.isEmpty()) {
            System.out.println("Didn't enter a word.");
            return;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            System.out.println("First and last characters the same");
        }
        else {
            System.out.println("First and last characters are different");
        }
    }
}
