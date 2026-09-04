package io.github.bgptii.ch9inheritance.projects;

import java.util.ArrayList;

public class P9_1King extends P9_1ChessPiece {

    public P9_1King(String position) {
        super(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> a = new ArrayList<>();
        int[] pos = getPositionIndexes();

        if (isValidIndexes(pos[0], pos[1] + 1)) {
            a.add(getPositionFromIndexes(pos[0], pos[1] + 1));
        }

        if (isValidIndexes(pos[0], pos[1] - 1)) {
            a.add(getPositionFromIndexes(pos[0], pos[1] - 1));
        }

        if (isValidIndexes(pos[0] + 1, pos[1])) {
            a.add(getPositionFromIndexes(pos[0] + 1, pos[1]));
        }

        if (isValidIndexes(pos[0] - 1, pos[1])) {
            a.add(getPositionFromIndexes(pos[0] - 1, pos[1]));
        }

        return a;
    }
}