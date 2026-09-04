package io.github.bgptii.ch2usingobjects.exercises;

import javax.swing.JComponent;
import java.awt.*;

public class E2_19TwoSquareComponent extends JComponent {

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(50, 50, 100, 100);
        g2.draw(box);
        Rectangle box2 = new Rectangle(75, 75, 50, 50);
        g2.draw(box2);
    }

}
