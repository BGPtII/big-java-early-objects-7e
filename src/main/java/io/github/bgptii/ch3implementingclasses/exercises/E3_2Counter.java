package io.github.bgptii.ch3implementingclasses.exercises;

/**
 *
 */
public class E3_2Counter {

    private int value;
    private int limit;

    public int value() {
        return value;
    }

    public int limit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit cannot be negative.");
        }
        this.limit = limit;
    }

    public void click() {
        value = Math.min(value + 1, limit);
    }

    public void reset() {
         value = 0;
    }

}
