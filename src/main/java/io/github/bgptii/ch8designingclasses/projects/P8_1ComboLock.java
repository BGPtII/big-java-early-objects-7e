package io.github.bgptii.ch8designingclasses.projects;

/**
 *
 */
public class P8_1ComboLock {

    private int secret1;
    private int secret2;
    private int secret3;
    private int dial;
    private byte attemptsCorrect;

    public P8_1ComboLock(int secret1, int secret2, int secret3) {
        if (secret1 < 0 || secret1 > 39 || secret2 < 0 || secret2 > 39 || secret3 < 0 || secret3 > 39) {
            throw new IllegalArgumentException("Combination numbers each must be between inclusive 0 and 39");
        }
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
    }

    public void reset() {
        dial = 0;
        attemptsCorrect = 0;
    }

    public void turnLeft(int ticks) {
        dial = Math.floorMod(dial - ticks, 40);
        if (attemptsCorrect == 1 && dial == secret2) {
            attemptsCorrect++;
        }
        else {
            attemptsCorrect = 0;
        }
    }

    public void turnRight(int ticks) {
        dial = (dial + ticks) % 40;
        if ((attemptsCorrect == 0 && dial == secret1) || attemptsCorrect == 2 && dial == secret3) {
            attemptsCorrect++;
        }
        else {
            attemptsCorrect = 0;
        }
    }

    /**
     * @return true if the user first turned it right to the first number in the combination, then left
     * to the second, and then right to the third
     */
    public boolean open() {
        return attemptsCorrect == 3;
    }

}
