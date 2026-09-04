package io.github.bgptii.ch2usingobjects.projects;

import javax.swing.*;

public class P215TrafficLightViewer {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setTitle("Traffic Light");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        P215TrafficLightComponent component = new P215TrafficLightComponent();
        frame.add(component);
        frame.setVisible(true);
    }

}
