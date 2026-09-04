package io.github.bgptii.ch9inheritance.projects;

import java.util.ArrayList;

public class P9_1Rook extends P9_1ChessPiece {

    public P9_1Rook(String position) {
        super(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> a = new ArrayList<>();
        int[] pos = getPositionIndexes();

        int newY = pos[1];
        while (++newY <= 7) {
            a.add(getPositionFromIndexes(pos[0], newY));
        }

        newY = pos[1];
        while (--newY >= 0) {
            a.add(getPositionFromIndexes(pos[0], newY));
        }

        int newX = pos[0];
        while (++newX <= 7) {
            a.add(getPositionFromIndexes(newX, pos[1]));
        }

        newX = pos[0];
        while (--newX >= 0) {
            a.add(getPositionFromIndexes(newX, pos[1]));
        }

        return a;
    }
}