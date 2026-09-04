package io.github.bgptii.ch2usingobjects.exercises;

import java.awt.Rectangle;

/**
 * Write a program that constructs a rectangle with area 42 and a rectangle with perimeter 42.
 * Print the widths and heights of both rectangles.
 */
public class E2_5AreaAndPerimeterRectangles42 {

    public static void main(String[] args) {
        Rectangle a = new Rectangle(21, 2);
        Rectangle p = new Rectangle(10, 1);
        System.out.println("Area 42 rectangle - height:" + a.height + ", width: " + a.width);
        System.out.println("Perimeter 42 rectangle - height:" + p.height + ", width: " + p.width);
    }
}
