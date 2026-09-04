package io.github.bgptii.ch9inheritance.projects;

import java.util.ArrayList;

public class P9_1Pawn extends P9_1ChessPiece {

    private final P9_1ChessPieceColour colour;

    public P9_1Pawn(String position, P9_1ChessPieceColour colour) {
        super(position);
        if (colour == null) {
            throw new IllegalArgumentException("Chess piece colour cannot be null");
        }
        this.colour = colour;
    }

    @Override
    public ArrayList<String> canMoveTo() {
        ArrayList<String> a = new ArrayList<>();
        int[] pos = getPositionIndexes();
        int startingY = (colour == P9_1ChessPieceColour.WHITE) ? 1 : 6;
        int dir = (colour == P9_1ChessPieceColour.WHITE) ? 1 : -1;
        int newY = pos[1] + dir;
        if (isValidIndexes(pos[0], newY)) {
            a.add(getPositionFromIndexes(pos[0], newY));
        }
        if (pos[1] == startingY) { // Can advance forward twice
            newY = pos[1] + dir * 2;
            a.add(getPositionFromIndexes(pos[0], newY));
        }
        return a;
    }

}
