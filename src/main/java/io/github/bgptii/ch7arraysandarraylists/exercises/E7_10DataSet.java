package io.github.bgptii.ch7arraysandarraylists.exercises;

public class E7_10DataSet {

    private double[] doubles;
    private int length;

    public E7_10DataSet(int maximumNumberOfValues) {
        if (maximumNumberOfValues < 1) {
            throw new IllegalArgumentException("Max number of values must be > 0");
        }
        this.doubles = new double[maximumNumberOfValues];
    }

    public void add(double d) {
        if (length == doubles.length) {
            throw new IllegalArgumentException("DataSet is full");
        }
        doubles[length++] = d;
    }

    public double sum() {
        double total = 0;
        for (int i = 0; i < length; i++) {
            total += doubles[i];
        }
        return total;
    }

    public double average() {
        return sum() / length;
    }

    public double maximum() {
        if (length == 0) {
            throw new IllegalStateException("DataSet is empty.");
        }
        double max = -Double.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (doubles[i] > max) {
                max = doubles[i];
            }
        }
        return max;
    }

    public double minimum() {
        if (length == 0) {
            throw new IllegalStateException("DataSet is empty.");
        }
        double min = Double.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (doubles[i] < min) {
                min = doubles[i];
            }
        }
        return min;
    }

}
