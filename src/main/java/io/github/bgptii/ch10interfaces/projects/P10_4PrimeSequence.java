package io.github.bgptii.ch10interfaces.projects;

public class P10_4PrimeSequence implements P10_4Sequence {

    private int current;

    public P10_4PrimeSequence() {
        current = 2;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int next() {
        while (!isPrime(current)) {
            current++;
        }
        int result = current;
        current++;
        return result;
    }

}
