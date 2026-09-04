package io.github.bgptii.ch1introduction.projects;

/**
 * You want to decide whether you should drive your car to work or take the train.
 * You know the one-way distance from your home to your place of work, and the
 * fuel efficiency of your car (in miles per gallon). You also know the one-way price of
 * a train ticket. You assume the cost of gas at $4 per gallon, and car maintenance at 5
 * cents per mile. Write an algorithm to decide which commute is cheaper.
 */
public class P1_1CommuteCostComparison {

    public static void main(String[] args) {
        double totalCarCost = getTotalCarCost();

        double trainTicketCostOneWay = 10;
        double totalTrainCost = trainTicketCostOneWay * 2;

        System.out.println("Total car cost: " + totalCarCost + ", Total train cost: " + totalTrainCost);
        if (totalCarCost < totalTrainCost) {
            System.out.println("Driving is cheaper.");
        }
        else if (totalTrainCost < totalCarCost) {
            System.out.println("Taking the train is cheaper.");
        }
        else {
            System.out.println("Both options cost the same.");
        }

    }

    private static double getTotalCarCost() {
        double oneWayWorkDistanceMiles = 3; // doubles 64-bit, floats 32-bit, therefore doubles more precise
        double milesPerGallon = 25;
        double costOfGasPerGallon = 4;
        double totalWorkDistanceMiles = oneWayWorkDistanceMiles * 2;
        double carMaintenancePerMile = 0.05;
        double gallonsConsumed = totalWorkDistanceMiles / milesPerGallon;
        double totalGasCost = gallonsConsumed * costOfGasPerGallon;
        double carMaintenanceCost = totalWorkDistanceMiles * carMaintenancePerMile;
        return carMaintenanceCost + totalGasCost;
    }
}
