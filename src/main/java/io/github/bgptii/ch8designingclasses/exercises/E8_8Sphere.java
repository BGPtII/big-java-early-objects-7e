package io.github.bgptii.ch8designingclasses.exercises;

public class E8_8Sphere implements E8_83DShape {

    private double r;

    public E8_8Sphere(double r) {
        if (r <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
        this.r = r;
    }

    @Override
    public double volume() {
        return (4 / 3.0) * Math.PI * Math.pow(r, 3);
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * Math.pow(r, 2);
    }

}
