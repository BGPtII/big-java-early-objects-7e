package io.github.bgptii.ch10interfaces.practiceexercises;

import java.util.ArrayList;
import java.util.HashMap;

public class E10_14Grid {

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

        @Override
        public int hashCode() {
            return 31 * row + column;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Location)) {
                return false;
            }
            Location loc = (Location) obj;
            return getRow() == loc.getRow() && getColumn() == loc.getColumn();
        }

    }

    private final HashMap<Location, String> descriptions;

    public E10_14Grid() {
        descriptions = new HashMap<>();
    }

    public void add(int row, int column, String description) {
        descriptions.put(new Location(row, column), description);
    }

    public String getDescription(int row, int column) {
        return descriptions.get(new Location(row, column));
    }

    public ArrayList<E10_14Grid.Location> getDescribedLocations() {
        return new ArrayList<>(descriptions.keySet());
    }

}
