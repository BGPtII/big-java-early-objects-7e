package io.github.bgptii.ch1introduction.projects;

/**
 * You want to find out which fraction of your car’s use is for commuting to work,
 * and which is for personal use. You know the one-way distance from your home to
 * work. For a particular period, you recorded the beginning and ending mileage on the
 * odometer and the number of work days. Write an algorithm to settle this question.
 */
public class P1_2CarUsageCalculator {

    public static void main(String[] args) {
        int beginningOdometer = 1000;
        int endingOdometer = 1045;
        int milesTotalCommutePeriod = endingOdometer - beginningOdometer;

        int oneWayHomeToWorkMiles = 4;
        int commutePeriodWorkDays = 5;

        int commutePeriodWorkMiles = oneWayHomeToWorkMiles * 2 * commutePeriodWorkDays;
        int commutePeriodPersonalMiles = milesTotalCommutePeriod - commutePeriodWorkMiles;
        System.out.println("Total commute period miles: " + milesTotalCommutePeriod + ", Total commute work miles: " + commutePeriodWorkMiles + ", Total commute personal miles: " + commutePeriodPersonalMiles);
    }

}
