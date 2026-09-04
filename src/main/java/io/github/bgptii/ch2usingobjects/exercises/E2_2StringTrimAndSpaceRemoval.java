package io.github.bgptii.ch2usingobjects.exercises;

/**
 * Look into the API documentation of the String class and locate the trim method.
 * Write a program demonstrating what it does. Then show how you can use the
 * replace method to remove all spaces from a string.
 */
public class E2_2StringTrimAndSpaceRemoval {

    public static void main(String[] args) {
        String s = "     Hello, world!   ";
        System.out.println("Original: \"" + s + "\"");
        System.out.println("Post-trim: \"" + s.trim() + "\"");
        System.out.println("Post-replaceAll: \"" + s.replaceAll(" ", "") + "\"");

    }
}
