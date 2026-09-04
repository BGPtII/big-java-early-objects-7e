package io.github.bgptii.ch2usingobjects.exercises;

import javax.swing.*;

/**
 * Draws 2 squares with the same center
 */
public class E2_19TwoSquareViewer {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setTitle("Two Squares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        E2_19TwoSquareComponent component = new E2_19TwoSquareComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}
