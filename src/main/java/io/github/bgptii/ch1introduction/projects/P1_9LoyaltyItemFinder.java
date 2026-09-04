package io.github.bgptii.ch1introduction.projects;

/*
Suppose you received a loyalty promotion that lets you purchase one item, valued
up to $100, from an online catalog. You want to make the best of the offer. You have
a list of all items for sale, some of which are less than $100, some more. Write an
algorithm to produce the item that is closest to $100. If there is more than one such
item, list them all. Remember that a computer will inspect one item at a time—it
can’t just glance at a list and find the best one.
 */
public class P1_9LoyaltyItemFinder {

    public static void main(String[] args) {
        String[] itemNames = new String[] {
                "Tuba",
                "Jello",
                "Horse",
                "Bucket",
                "String"
        };
        double[] itemPrices = new double[] {
                45.99,
                1.29,
                168.5,
                10,
                0.99
        };

        double lowestDiffFrom100 = Double.MAX_VALUE;
        int lowestDiffFrom100I = -1;
        for (int i = 0; i < itemNames.length; i++) {
            if (itemPrices[i] > 100) {
                continue;
            }
            double diffFrom100 = 100 - itemPrices[i];
            if (diffFrom100 < lowestDiffFrom100) { // Don't include items > $100
                lowestDiffFrom100 = diffFrom100;
                lowestDiffFrom100I = i;
            }
        }
        if (lowestDiffFrom100I == -1) {
            System.out.println("All prices over $100, nothing eligible.");
        }
        else {
            for (int i = 0; i < itemNames.length; i++) {
                if (itemPrices[i] == itemPrices[lowestDiffFrom100I]) {
                    System.out.println("Item closest to 100 is: " + itemNames[i] + " at a price of: " + itemPrices[i]);
                }
            }
        }
    }
}
