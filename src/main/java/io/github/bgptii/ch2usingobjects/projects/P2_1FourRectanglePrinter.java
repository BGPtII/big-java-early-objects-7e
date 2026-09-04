package io.github.bgptii.ch2usingobjects.projects;

import java.awt.Rectangle;

/**
 * Write a program called FourRectanglePrinter that constructs a Rectangle
 * object, prints its location by calling System.out.println(box), and then
 * translates and prints it three more times, so that, if the rectangles were
 * drawn, they would form one large rectangle.
 */
public class P2_1FourRectanglePrinter {

    public static void main(String[] args) {
        Rectangle box = new Rectangle(0, 0, 2, 4);
        System.out.println(box);
        box.translate(0, 4);
        System.out.println(box);
        box.translate(2, 0);
        System.out.println(box);
        box.translate(0, -4);
        System.out.println(box);
    }
}
