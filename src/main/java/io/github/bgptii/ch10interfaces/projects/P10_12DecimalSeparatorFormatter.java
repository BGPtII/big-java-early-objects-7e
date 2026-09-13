package io.github.bgptii.ch10interfaces.projects;

public class P10_12DecimalSeparatorFormatter implements P10_12NumberFormatter {

    @Override
    public String format(int n) {
        boolean isNegative = n < 0;
        String s = "" + Math.abs(n);

        for (int i = s.length() - 3; i > 0; i-= 3) {
            s = s.substring(0, i) + "," + s.substring(i);
        }

        if (isNegative) {
            s = "-" + s;
        }
        return s;
    }

}
