package io.github.bgptii.ch7arraysandarraylists.exercises;

public class E7_14Sequence {

    private int[] values;

    public E7_14Sequence(int size) {
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
    public boolean isPermutationOf(E7_14Sequence other) {
        if (other == null || other.values.length != values.length) {
            return false;
        }
        for (int i = 0; i < values.length; i++) {
            if (count(values[i]) != other.count(values[i])) {
                return false;
            }
        }
        return true;
    }
    private int count(int value) {
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value) {
                total++;
            }
        }
        return total;
    }

}
