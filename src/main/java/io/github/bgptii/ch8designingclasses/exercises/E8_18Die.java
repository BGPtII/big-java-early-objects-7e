package io.github.bgptii.ch8designingclasses.exercises;

import java.util.Random;

public class E8_18Die {

    private static Random generator = new Random();
    private int sides;

    /**
     * Constructs a die with a given number of sides
     * @param s the number of sides, e.g., 6 for a normal die
     */
    public E8_18Die(int s) {
        sides = s;
    }

    public int cast() {
        return 1 + generator.nextInt(sides);
    }

}
