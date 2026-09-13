package io.github.bgptii.ch10interfaces.projects;

/**
 * Formats the number in base n, where n is any number between 2 and 36 that is provided in the constructor
 */
public class P10_12BaseFormatter implements P10_12NumberFormatter {

    private final int base;

    public P10_12BaseFormatter(int base) {
        if (base > 36 || base < 2) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }
        this.base = base;
    }

    @Override
    public String format(int n) {
        if (n == 0) {
            return "0";
        }
        String s = "";
        boolean isNegative = n < 0;
        n = Math.abs(n);
        while (n != 0) {
            int r = n % base;
            char c;
            if (r <= 9) {
                c = (char) ('0' + r);
            }
            else {
                c = (char) ('A' + (r - 10));
            }
            s = c + s;
            n /= base;
        }
        if (isNegative) {
            s = "-" + s;
        }
        return s;
    }

}
