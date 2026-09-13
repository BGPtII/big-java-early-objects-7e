package io.github.bgptii.ch10interfaces.practiceexercises;

public interface E10_4Sequence {

    int next();

    static E10_4Sequence multiplesOf(int n) {
        return new E10_4Sequence() {
            int current = 0;
            @Override
            public int next() {
                current++;
                return n * current;
            }

        };
    }

    static E10_4Sequence powersOf(int n) {
        return new E10_4Sequence() {
            int current = 0;
            @Override
            public int next() {
                current++;
                return (int) Math.pow(current, n);
            }
        };
    }

}
