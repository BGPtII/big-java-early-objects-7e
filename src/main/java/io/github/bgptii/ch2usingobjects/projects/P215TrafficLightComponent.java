package io.github.bgptii.ch2usingobjects.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class P215TrafficLightComponent extends JComponent {

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle r = new Rectangle(50, 50, 30, 90);
        g2.fill(r);
        Ellipse2D.Double e1 = new Ellipse2D.Double(50, 50, 30, 30);
        g2.setColor(Color.RED);
        g2.fill(e1);
        Ellipse2D.Double e2 = new Ellipse2D.Double(50, 80, 30, 30);
        g2.setColor(Color.YELLOW);
        g2.fill(e2);
        Ellipse2D.Double e3 = new Ellipse2D.Double(50, 110, 30, 30);
        g2.setColor(Color.GREEN);
        g2.fill(e3);
    }

}
