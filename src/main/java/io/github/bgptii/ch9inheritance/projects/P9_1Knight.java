package io.github.bgptii.ch9inheritance.projects;

import java.util.ArrayList;

public class P9_1Knight extends P9_1ChessPiece {

    public P9_1Knight(String position) {
        super(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> a = new ArrayList<>();
        int[] pos = getPositionIndexes();
        if (isValidIndexes(pos[0] + 1, pos[1] + 2)) {
            a.add(getPositionFromIndexes(pos[0] + 1, pos[1] + 2));
        }
        if (isValidIndexes(pos[0] - 1, pos[1] + 2)) {
            a.add(getPositionFromIndexes(pos[0] - 1, pos[1] + 2));
        }
        if (isValidIndexes(pos[0] + 1, pos[1] - 2)) {
            a.add(getPositionFromIndexes(pos[0] + 1, pos[1] - 2));
        }
        if (isValidIndexes(pos[0] - 1, pos[1] - 2)) {
            a.add(getPositionFromIndexes(pos[0] - 1, pos[1] - 2));
        }
        if (isValidIndexes(pos[0] + 2, pos[1] + 1)) {
            a.add(getPositionFromIndexes(pos[0] + 2, pos[1] + 1));
        }
        if (isValidIndexes(pos[0] + 2, pos[1] - 1)) {
            a.add(getPositionFromIndexes(pos[0] + 2, pos[1] - 1));
        }
        if (isValidIndexes(pos[0] - 2, pos[1] + 1)) {
            a.add(getPositionFromIndexes(pos[0] - 2, pos[1] + 1));
        }
        if (isValidIndexes(pos[0] - 2, pos[1] - 1)) {
            a.add(getPositionFromIndexes(pos[0] - 2, pos[1] - 1));
        }
        return a;
    }

}
