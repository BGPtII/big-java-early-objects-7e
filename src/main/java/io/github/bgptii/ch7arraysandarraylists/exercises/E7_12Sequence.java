package io.github.bgptii.ch7arraysandarraylists.exercises;

public class E7_12Sequence {

    private int[] values;

    public E7_12Sequence(int size) {
        values = new int[size];
    }

    public void set(int i, int n) {
        values[i] = n;
    }

    public int get(int i) {
        return values[i];
    }

    public int size() {
        return values.length;
    }

    public boolean equals(E7_12Sequence other) {
        if (other == null || other.values.length != values.length) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] != other.values[i]) {
                return false;
            }
        }
        return true;
    }

}
