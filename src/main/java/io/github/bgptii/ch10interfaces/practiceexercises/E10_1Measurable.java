package io.github.bgptii.ch10interfaces.practiceexercises;

public interface E10_1Measurable {

    double getMeasure();

    static double average(E10_1Measurable[] objects) {
        double sum = 0;
        for (E10_1Measurable obj : objects) {
            sum = sum + obj.getMeasure();

        }
        if (objects.length > 0) {
            return sum / objects.length;
        }
        else {
            return 0;
        }
    }

    static E10_1Measurable largest(E10_1Measurable[] objects) {
        E10_1Measurable largest = objects[0];
        for (E10_1Measurable obj : objects) {
            if (obj.getMeasure() > largest.getMeasure()) {
                largest = obj;
            }
        }
        return largest;
    }

    static E10_1Measurable smallest(E10_1Measurable[] objects) {
        E10_1Measurable smallest = objects[0];
        for (E10_1Measurable obj : objects) {
            if (obj.getMeasure() > smallest.getMeasure()) {
                smallest = obj;
            }
        }
        return smallest;
    }

}
