package io.github.bgptii.ch10interfaces.projects;

import org.jetbrains.annotations.NotNull;

public class P10_1Segment implements CharSequence {

    private final String s;
    private final int startI;
    private final int endI;

    public P10_1Segment(String s, int startI, int endI) {
        if (s == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        if (startI < 0 || endI > s.length() || startI > endI) {
            throw new IllegalArgumentException("Invalid segment indexes");
        }
        this.s = s;
        this.startI = startI;
        this.endI = endI;
    }

    @Override
    public int length() {
        return endI - startI;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= length()) {
            throw new IllegalArgumentException("Index cannot exceed the bounds of the segment");
        }
        return s.charAt(startI + index);
    }

    @NotNull
    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || end > length() || start > end) {
            throw new IllegalArgumentException("Invalid subsequence indexes");
        }
        return new P10_1Segment(s, startI + start, startI + end);
    }

}
