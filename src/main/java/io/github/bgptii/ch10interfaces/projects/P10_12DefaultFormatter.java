package io.github.bgptii.ch10interfaces.projects;

/**
 * Formats an integer in the usual way
 */
public class P10_12DefaultFormatter implements P10_12NumberFormatter {

    @Override
    public String format(int n) {
        return "" + n;
    }

}
