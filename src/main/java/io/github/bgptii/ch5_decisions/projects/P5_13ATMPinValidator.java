package io.github.bgptii.ch5_decisions.projects;

import java.util.Scanner;

public class P5_13ATMPinValidator {

    private static final String PIN = "1234";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        byte attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter the PIN: ");
            String s = in.nextLine();
            if (s.equals(PIN)) {
                System.out.println("Entered correct PIN");
                break;
            }
            else if (--attempts != 0)  {
                System.out.println("Incorrect PIN, attempts til lockout: " + attempts);
            }
        }
        if (attempts == 0) {
            System.out.println("Your bank card has been blocked.");
        }
    }

}
