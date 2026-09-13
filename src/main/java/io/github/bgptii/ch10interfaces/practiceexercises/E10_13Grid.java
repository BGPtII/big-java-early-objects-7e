package io.github.bgptii.ch10interfaces.practiceexercises;

import java.util.ArrayList;

public class E10_13Grid {

    public class Location {

        private final int row;
        private final int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

    }

    private final int numRows;
    private final int numColumns;
    private final String[][] descriptions;

    public E10_13Grid(int numRows, int numColumns) {
        if (numRows <= 0 || numColumns <= 0) {
            throw new IllegalArgumentException("Rows and columns must be greater than 0");
        }
        this.numRows = numRows;
        this.numColumns = numColumns;
        descriptions = new String[numRows][numColumns];
    }

    public void add(int row, int column, String description) {
        if (row < 0 || row >= numRows) {
            throw new IllegalArgumentException("Row is out of bounds");
        }
        if (column < 0 || column >= numColumns) {
            throw new IllegalArgumentException("Column is out of bounds");
        }
        descriptions[row][column] = description;
    }

    public String getDescription(int row, int column) {
        return descriptions[row][column];
    }

    public ArrayList<Location> getDescribedLocations() {
        ArrayList<Location> a = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                if (descriptions[row][col] != null) {
                    a.add(new Location(row, col));
                }
            }
        }
        return a;
    }

}
