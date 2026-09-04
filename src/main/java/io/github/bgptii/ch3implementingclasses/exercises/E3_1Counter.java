package io.github.bgptii.ch3implementingclasses.exercises;

public class E3_1Counter {

    private int value;

    public int value() {
        return value;
    }

    public void click() {
        value++;
    }

    public void reset() {
        value = 0;
    }

    public void undo() {
        value = Math.max(value - 1, 0);
    }

}
