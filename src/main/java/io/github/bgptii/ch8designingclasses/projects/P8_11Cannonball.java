package io.github.bgptii.ch8designingclasses.projects;

import java.awt.Point;
import java.util.ArrayList;

public class P8_11Cannonball {

    private double xPos;
    private double yPos;
    private double xVelocity;
    private double yVelocity;

    public P8_11Cannonball(double xPos) {
        this.xPos = xPos;
    }

    public void move(double deltaSec) {
        xPos += xVelocity * deltaSec;
        yPos += yVelocity * deltaSec;
        yVelocity -= 9.81 * deltaSec;
    }

    public Point getLocation() {
        return new Point((int) Math.round(xPos), (int) Math.round(yPos));
    }

    /**
     * Keep calling move with the given time interval until the y-position is 0
     * @param alpha the angle
     * @param v x velocity
     * @param deltaSec the amount of time that passes
     * @return an array list of locations after each call to move
     */
    public ArrayList<Point> shoot(double alpha, double v, double deltaSec) {
        if (alpha <= 0 || alpha >= 180) {
            throw new IllegalArgumentException("Alpha can only be > 0 and < 180 degrees");
        }
        if (v <= 0) {
            throw new IllegalArgumentException("Velocity must be > 0");
        }
        if (deltaSec <= 0) {
            throw new IllegalArgumentException("Time delta in seconds must be > 0");
        }
        double radians = Math.toRadians(alpha);
        xVelocity = v * Math.cos(radians);
        yVelocity = v * Math.sin(radians);
        ArrayList<Point> locations = new ArrayList<>();
        move(deltaSec);
        locations.add(getLocation());
        while (yPos > 0) {
            move(deltaSec);
            locations.add(getLocation());
        }
        return locations;
    }

}
