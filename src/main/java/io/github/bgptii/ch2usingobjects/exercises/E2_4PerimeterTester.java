package io.github.bgptii.ch2usingobjects.exercises;

import java.awt.Rectangle;

/**
 * Write a PerimeterTester program that constructs a Rectangle object and then computes and prints its perimeter.
 * Use the getWidth and getHeight methods. Also print the expected answer.
 */
public class E2_4PerimeterTester {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 9);
        System.out.println("Expected perimeter: " + 24);
        System.out.println("Actual perimeter: " + (r.height * 2 + r.width * 2));
    }

}
