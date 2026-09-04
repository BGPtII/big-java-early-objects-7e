package io.github.bgptii.ch8designingclasses.exercises;

public class E8_8Cone implements E8_83DShape {

    private double r;
    private double h;

    public E8_8Cone(double r, double h) {
        if (r <= 0 || h <= 0) {
            throw new IllegalArgumentException("Radius and height must both be greater than 0");
        }
        this.r = r;
        this.h = h;
    }

    @Override
    public double volume() {
        return Math.PI * Math.pow(r, 2) * (h / 3.0);
    }

    @Override
    public double surfaceArea() {
        return Math.PI * r * (r + Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2)));
    }

}
