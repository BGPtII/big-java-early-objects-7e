package io.github.bgptii.ch10interfaces.projects;

/**
 * Formats negative numbers with parentheses; for example, –1 as (1)
 */
public class P10_12AccountingFormatter implements P10_12NumberFormatter {

    @Override
    public String format(int n) {
        if (n < 0) {
            return "(" + Math.abs(n) + ")";
        }
        return n + "";
    }

}
