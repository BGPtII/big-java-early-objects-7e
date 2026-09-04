package io.github.bgptii.ch8designingclasses.exercises;

public class E8_8Cube implements E8_83DShape {

    private double h;

    private E8_8Cube(double h) {
        if (h <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.h = h;
    }

    @Override
    public double volume() {
        return Math.pow(h, 3);
    }

    @Override
    public double surfaceArea() {
        return 6 * Math.pow(h, 2);
    }

}
