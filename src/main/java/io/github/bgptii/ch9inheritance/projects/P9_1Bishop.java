package io.github.bgptii.ch9inheritance.projects;

import java.util.ArrayList;

public class P9_1Bishop extends P9_1ChessPiece {

    public P9_1Bishop(String position) {
        super(position);
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> a = new ArrayList<>();
        int[] pos = getPositionIndexes();

        int newX = pos[0];
        int newY = pos[1];
        while (++newX <= 7 && ++newY <= 7) {
            a.add(getPositionFromIndexes(newX, newY));
        }

        newX = pos[0];
        newY = pos[1];
        while (--newX >= 0 && ++newY <= 7) {
            a.add(getPositionFromIndexes(newX, newY));
        }

        newX = pos[0];
        newY = pos[1];
        while (++newX <= 7 && --newY >= 0) {
            a.add(getPositionFromIndexes(newX, newY));
        }

        newX = pos[0];
        newY = pos[1];
        while (--newX >= 0 && --newY >= 0) {
            a.add(getPositionFromIndexes(newX, newY));
        }

        return a;
    }

}
