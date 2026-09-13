package io.github.bgptii.ch12objectorienteddesign.exercises;

/**
 * Describes a product with a description and a price.
 */
public class E12_1Product {

    private String description;
    private double price;

    /**
     * Constructs a product from a description and a price
     * @param description the product description
     * @param price the product price
     */
    public E12_1Product(String description, double price) {
        this.description = description;
        this.price = price;
    }

    /**
     * Gets the product description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the product price
     * @return the unit price
     */
    public double getPrice() {
        return price;
    }

}
