package io.github.bgptii.ch10interfaces.practiceexercises;

import java.util.Scanner;

public class E10_29PersonComparisonDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        E10_29Person[] persons = new E10_29Person[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter a name: ");
            persons[i] = new E10_29Person(in.nextLine());
        }
        E10_29Person first = persons[0];
        E10_29Person last = persons[0];
        for (int i = 1; i < persons.length; i++) {
            if (persons[i].compareTo(first) < 0) {
                first = persons[i];
            }
            if (persons[i].compareTo(last) > 0) {
                last = persons[i];
            }
        }
        System.out.println("First: " + first);
        System.out.println("Last: " + last);
    }

}
