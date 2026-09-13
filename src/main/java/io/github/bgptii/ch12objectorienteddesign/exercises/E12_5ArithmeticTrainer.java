package io.github.bgptii.ch12objectorienteddesign.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 * - Level 1: 2 addends whose sum is less than 10
 * - Level 2: 2 arbitrary single-digit addends
 * - Level 3: A 1-digit minuend and subtrahend whose result is non-negative
 */
public class E12_5ArithmeticTrainer {

    private static final Random random = new Random();
    private static int level = 1;
    private static int currentAnswer;

    private static String generateQuestion() {
        String operand = (level > 2) ? " - " : " + ";
        String s = "";
        switch (level) {
            case 1:
                {
                    int addend1;
                    int addend2;
                    do {
                        addend1 = random.nextInt(10);
                        addend2 = random.nextInt(10);
                        currentAnswer = addend1 + addend2;
                    }
                    while (currentAnswer >= 10);
                    s = addend1 + operand + addend2;
                }
                break;
            case 2:
                {
                    int addend1 = random.nextInt(10);
                    int addend2 = random.nextInt(10);
                    currentAnswer = addend1 + addend2;
                    s = addend1 + operand + addend2;
                }
                break;
            case 3:
                int minuend;
                int subtrahend;
                do {
                    minuend = random.nextInt(10);
                    subtrahend = random.nextInt(10);
                    currentAnswer = minuend - subtrahend;
                }
                while (currentAnswer < 0);
                s = minuend + operand + subtrahend;
                break;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int score = 0;
        int attempt = 0;
        String question = "";

        while (true) {
            System.out.println("Arithmetic Trainer | Level: " + level + " | Score: " + score + " (\"q\" to quit)");
            if (attempt == 0 || attempt >= 2) {
                question = generateQuestion();
                attempt = 0;
            }
            System.out.print(question);
            if (in.hasNextInt()) {
                int opt = in.nextInt();
                in.nextLine();
                if (opt == currentAnswer) {
                    System.out.println("Correct answer!");
                    attempt = 0;
                    if (++score == 5 && level < 3) {
                        System.out.println("Advanced a level!");
                        level++;
                        score = 0;
                    }
                }
                else {
                    attempt++;
                }
            }
            else {
                String input = in.nextLine().trim();
                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Exiting program");
                    return;
                }
                else {
                    System.out.println("Invalid answer format");
                    attempt++;
                }
            }
        }

    }

}
