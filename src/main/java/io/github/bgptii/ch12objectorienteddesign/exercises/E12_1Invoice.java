package io.github.bgptii.ch12objectorienteddesign.exercises;

import java.util.ArrayList;

/**
 * Describes an invoice for a set of purchased products.
 */
public class E12_1Invoice {

    private E12_1Address billingAddress;
    private ArrayList<E12_1LineItem> items;

    /**
     * Adds a charge for a product to this invoice
     * @param product the product that the customer ordered
     * @param quantity the quantity of the product
     */
    public void add(E12_1Product product, int quantity) {
        E12_1LineItem item = new E12_1LineItem(quantity, product);
        items.add(item);
    }

    /**
     * Formats the invoice
     * @return the formatted invoice
     */
    public String format() {
        String r = String.format("%32s%n%n", "I N V O I C E")
                + billingAddress.format() + String.format("%n%n%-30s%8s%5s%8s%n", "Description", "Price", "Qty", "Total");
        for (E12_1LineItem item : items) {
            r = String.format("%s%s%n", r, item.format());
        }
        r = r + String.format("%nAMOUNT DUE: $%8.2f%n", getAmountDue());
        return r;
    }

    /**
     * Computes the total amount due
     * @return the amount due
     */
    private double getAmountDue() {
        double amountDue = 0;
        for (E12_1LineItem item : items) {
            amountDue += item.getTotalPrice();
        }
        return amountDue;
    }

}
