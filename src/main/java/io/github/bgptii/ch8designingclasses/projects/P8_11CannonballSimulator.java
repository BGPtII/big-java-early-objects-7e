package io.github.bgptii.ch8designingclasses.projects;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class P8_11CannonballSimulator {

    public static void main(String[] args) {
        final double DELTA_SEC = 1;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the starting angle: ");
        double a, v;
        if (!in.hasNextDouble() || (a = in.nextDouble()) <= 0 || a >= 180) {
            throw new IllegalArgumentException("Angle must be valid (180 > a > 0)");
        }
        System.out.print("Enter the initial velocity: ");
        if (!in.hasNextDouble() || (v = in.nextDouble()) <= 0) {
            throw new IllegalArgumentException("Velocity must be > 0");
        }
        P8_11Cannonball cannonball = new P8_11Cannonball(0);
        ArrayList<Point> points = cannonball.shoot(a, v, DELTA_SEC);
        for (Point p : points) {
            System.out.println(p);
        }
    }

}
