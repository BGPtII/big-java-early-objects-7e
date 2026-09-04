package io.github.bgptii.ch7arraysandarraylists.exercises;

public class E7_11ArrayMethodsTester {

    public static void main(String[] args) {
        E7_11ArrayMethods test1 = new E7_11ArrayMethods(new int[]{1, 4, 9, 16, 25});
        test1.shiftRight();
        System.out.println("shiftRight:");
        System.out.println("Expected: [25, 1, 4, 9, 16]");
        System.out.println("Actual: " + test1);
        System.out.println();

        E7_11ArrayMethods test2 = new E7_11ArrayMethods(new int[]{1, 4, 9, 16, 25});
        test2.replaceEvenWithZero();
        System.out.println("replaceEvenWithZero:");
        System.out.println("Expected: [1, 0, 9, 0, 25]");
        System.out.println("Actual: " + test2);
        System.out.println();

        E7_11ArrayMethods test3 = new E7_11ArrayMethods(new int[]{1, 2, 3, 4, 5});
        test3.removeMiddle();
        System.out.println("removeMiddle:");
        System.out.println("Expected: [1, 2, 4, 5]");
        System.out.println("Actual:   " + test3);
        System.out.println();

        E7_11ArrayMethods test4 = new E7_11ArrayMethods(new int[]{1, 2, 3, 4, 5, 6});
        test4.removeMiddle();
        System.out.println("removeMiddle:");
        System.out.println("Expected: [1, 2, 5, 6]");
        System.out.println("Actual: " + test4);
        System.out.println();

        E7_11ArrayMethods test5 = new E7_11ArrayMethods(new int[]{7, 4, 3, 8, 2, 5});
        test5.moveEvensToFront();
        System.out.println("moveEvensToFront:");
        System.out.println("Expected: [4, 8, 2, 7, 3, 5]");
        System.out.println("Actual: " + test5);
        System.out.println();

        E7_11ArrayMethods test6 = new E7_11ArrayMethods(new int[]{10, 5, 8, 3});
        System.out.println("getSecondLargest:");
        System.out.println("Expected: 8");
        System.out.println("Actual: " + test6.getSecondLargest());
    }

}
