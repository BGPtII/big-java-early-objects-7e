package io.github.bgptii.ch10interfaces.projects;

public class P10_13FormattedNumberPrinter {

    public static void print(int[] numbers, P10_12NumberFormatter numberFormatter) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Invalid array - cannot be null or of length 0");
        }
        if (numberFormatter == null) {
            throw new IllegalArgumentException("Number formatter cannot be null");
        }
        String[] formatted = new String[numbers.length];
        int maxLength = 0;
        for (int i = 0; i < numbers.length; i++) {
            formatted[i] = numberFormatter.format(numbers[i]);
            if (formatted[i].length() > maxLength) {
                maxLength = formatted[i].length();
            }
        }
        for (String f : formatted) {
            System.out.printf("%" + maxLength + "s%n",  f);
        }
    }

}
