package io.github.bgptii.ch5_decisions.projects;

public class P5_1Date {

    private int month;
    private int day;

    public P5_1Date(int month, int day) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12 inclusive.");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31 inclusive.");
        }
        this.month = month;
        this.day = day;
    }

    public String getSeason() {
        String s;
        if (month < 4) {
            s = "Winter";
        }
        else if (month < 7) {
            s = "Spring";
        }
        else if (month < 10) {
            s = "Summer";
        }
        else {
            s = "Fall";
        }
        if (month % 3 == 0 && day >= 21) {
            if (s.startsWith("W")) {
                s = "Spring";
            }
            else if (s.startsWith("Sp")) {
                s = "Summer";
            }
            else if (s.startsWith("Su")) {
                s = "Fall";
            }
            else {
                s = "Winter";
            }
        }
        return s;
    }

}
