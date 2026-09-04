package io.github.bgptii.ch8designingclasses.exercises;

public class E8_8Cylinder implements E8_83DShape {

    private double r;
    private double h;

    public E8_8Cylinder(double r, double h) {
        if (r <= 0 || h <= 0) {
            throw new IllegalArgumentException("Radius and height must both be greater than 0");
        }
        this.r = r;
        this.h = h;
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(r, 2) * h;
    }

    @Override
    public double surfaceArea() {
        return (2 * Math.PI * r * h) + (2 * Math.PI * Math.pow(r, 2));
    }

}
