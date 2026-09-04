package io.github.bgptii.ch9inheritance.projects;

import java.util.ArrayList;

public abstract class P9_1ChessPiece {

    private String position; // Chess board is 8x8 (a-h, 1-8)

    public P9_1ChessPiece(String position) {
        setPosition(position);
    }

    /**
     *
     * @param coordinates Identifies the row and column in chess notation, such as "d8" for the initial position of the black queen
     */
    public void setPosition(String coordinates) {
        if (!isValidPosition(coordinates)) {
            throw new IllegalArgumentException("Position must be in chess notation using a-h and 1-8, such as d8");
        }
        position = coordinates;
    }

    private boolean isValidPosition(String coordinates) {
        if (coordinates == null || coordinates.length() != 2) {
            return false;
        }
        return isValidIndexes(coordinates.charAt(0) - 'a', coordinates.charAt(1) - '1');
    }

    protected boolean isValidIndexes(int x, int y) {
        return x <= 7 && x >= 0 && y <= 7 && y >= 0;
    }

    public abstract ArrayList<String> canMoveTo();

    public String getPosition() {
        return position;
    }

    protected int[] getPositionIndexes() {
        return new int[] { position.charAt(0) - 'a', position.charAt(1) - '1' };
    }

    protected String getPositionFromIndexes(int x, int y) {
        if (x > 7 || x < 0 || y > 7 || y < 0) {
            throw new IllegalArgumentException("Position indexes must be between 0 and 7");
        }
        return "" + (char) ('a' + x) + (char) ('1' + y);
    }

}
