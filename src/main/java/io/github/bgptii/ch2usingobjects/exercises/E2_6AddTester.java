package io.github.bgptii.ch2usingobjects.exercises;

import java.awt.Rectangle;

public class E2_6AddTester {

    public static void main(String[] args) {
        Rectangle box = new Rectangle(5, 10, 20, 30);
        box.add(0, 0);
        System.out.println("Expected - x: 0, y: 0, width: 25, height: 40");
        System.out.println("Actual - x: " + box.x + ", y: " + box.y + ", width: " + box.width + ", height: " + box.height);
    }

}
