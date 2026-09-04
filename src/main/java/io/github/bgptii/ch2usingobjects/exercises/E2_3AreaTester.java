package io.github.bgptii.ch2usingobjects.exercises;

import java.awt.Rectangle;

/**
 * Write an AreaTester program that constructs a Rectangle object and then computes
 * and prints its area. Use the getWidth and getHeight methods. Also print the expected
 * answer.
 */
public class E2_3AreaTester {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(4, 8);
        System.out.println("Expected area: 32");
        System.out.println("Actual area: " + (r.height * r.width));
    }

}
