package io.github.bgptii.ch7arraysandarraylists.exercises;

public class E7_13Sequence {

    private int[] values;

    public E7_13Sequence(int size) {
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

    /**
     *
     * @param other sequence to compare
     * @return whether two sequences have the same values in some order, with the same multiplicities
     */
    public boolean sameValues(E7_13Sequence other) {
        if (other == null) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            boolean containsValue = false;
            for (int j = 0; j < other.values.length; j++) {
                if (value == other.values[j]) {
                    containsValue = true;
                    break;
                }
            }
            if (!containsValue) {
                return false;
            }
        }
        for (int i = 0; i < other.values.length; i++) {
            int value = other.values[i];
            boolean containsValue = false;
            for (int j = 0; j < values.length; j++) {
                if (value == values[j]) {
                    containsValue = true;
                    break;
                }
            }
            if (!containsValue) {
                return false;
            }
        }
        return true;
    }

}
