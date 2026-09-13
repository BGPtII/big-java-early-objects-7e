package io.github.bgptii.ch12objectorienteddesign.exercises;

/**
 * Describes a quantity of an article to purchase.
 */
public class E12_1LineItem {

    private int quantity;
    private E12_1Product product;

    /**
     * Constructs an item from the product and quantity
     * @param quantity the item quantity
     * @param product the product
     */
    public E12_1LineItem(int quantity, E12_1Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    /**
     * Computes the total cost of this line item
     * @return the total price
     */
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    /**
     * Formats this item
     * @return the formatted string of this item
     */
    public String format() {
        return String.format("%-30s%8.2f%5d%8.2f", product.getDescription(), product.getPrice(), quantity, getTotalPrice());
    }

}
