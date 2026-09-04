package io.github.bgptii.ch2usingobjects.exercises;

/**
 * Initializes a string with "Mississippi". Then replace all "i" with
 * "ii" and print the length of the resulting string. In that string, replace all "ss" with "s"
 * and print the length of the resulting string.
 */
public class E2_1MississippiStringReplacement {

    public static void main(String[] args) {
        String s = "Mississippi";
        s = s.replaceAll("i", "ii");
        s = s.replaceAll("ss", "s");
        System.out.println(s + " length: " + s.length());
    }
}
