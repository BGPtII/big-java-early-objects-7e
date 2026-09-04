package io.github.bgptii.ch7arraysandarraylists.exercises;

public class E7_11ArrayMethods {

    private int[] values;

    public E7_11ArrayMethods(int[] initialValues) {
        if (initialValues == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        values = initialValues;
    }

    public void swapFirstAndLast() {
        if (values.length > 1) {
            int temp = values[0];
            values[0] = values[values.length - 1];
            values[values.length - 1] = temp;
        }
    }

    /**
     * Shift all elements to the right by one and move the last element into the first
     * position. For example, 1 4 9 16 25 would be transformed into 25 1 4 9 16
     */
    public void shiftRight() {
        int temp = values[values.length - 1];
        for (int i = values.length - 1; i > 0; i--) {
            values[i] = values[i - 1];
        }
        values[0] = temp;
    }

    /**
     * Replace all even elements with zero
     */
    public void replaceEvenWithZero() {
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                values[i] = 0;
            }
        }
    }

    /**
     * Replace each element except the first and last by the larger of its two neighbors
     */
    public void replaceWithLargerNeighbor() {
        int temp = values[0];
        for (int i = 1; i < values.length - 1; i++) {
            int current = values[i];
            values[i] = Math.max(temp, values[i + 1]);
            temp = current;
        }
    }

    /**
     * Remove the middle element if the array length is odd, or the middle two
     * elements if the length is even.
     */
    public void removeMiddle() {
        boolean isOdd = values.length % 2 == 1;
        int middle = values.length / 2;
        int removedElements = isOdd ? 1 : 2;
        int[] newValues = new int[values.length - removedElements];
        int firstRemovedIndex = isOdd ? middle : middle - 1;

        for (int i = 0; i < firstRemovedIndex; i++) {
            newValues[i] = values[i];
        }
        for (int i = middle + 1; i < values.length; i++) {
            newValues[i - removedElements] = values[i];
        }
        values = newValues;
    }

    /**
     * Move all even elements to the front, otherwise preserving the order of the
     * elements
     */
    public void moveEvensToFront() {
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                for (int j = i; j > 0; j--) {
                    if (values[j - 1] % 2 != 0) {
                        int temp = values[j];
                        values[j] = values[j - 1];
                        values[j - 1] = temp;
                    }

                }
            }
        }
    }

    /**
     * @return the second-largest element in the array
     */
    public int getSecondLargest() {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE + 1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > largest) {
                secondLargest = largest;
                largest = values[i];
            }
            else if (values[i] > secondLargest) {
                secondLargest = values[i];
            }
        }
        return secondLargest;
    }

    /**
     * @return true if the array is currently sorted in increasing order.
     */
    public boolean isSortedIncreasing() {
        for (int i = 1; i < values.length; i++) {
            if (values[i] < values[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return true if the array contains two adjacent duplicate elements
     */
    public boolean hasAdjacentDuplicates() {
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if the array contains duplicate elements (which need not be adjacent)
     */
    public boolean hasDuplicates() {
        for (int i = 0; i < values.length - 1; i++) {
            int value = values[i];
            for (int j = i + 1; j < values.length; j++) {
                if (value == values[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(values);
    }

}
