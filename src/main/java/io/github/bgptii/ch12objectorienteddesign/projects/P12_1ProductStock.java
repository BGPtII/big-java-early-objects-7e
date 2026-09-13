package io.github.bgptii.ch12objectorienteddesign.projects;

public class P12_1ProductStock {

    private int currentStock;
    private final int maxStock;

    public P12_1ProductStock(int maxStock) {
        if (maxStock < 1) {
            throw new IllegalArgumentException("Maximum stock can't be less than 1");
        }
        this.currentStock = 0;
        this.maxStock = maxStock;
    }

    public P12_1ProductStock(int currentStock, int maxStock) {
        if (maxStock < 1) {
            throw new IllegalArgumentException("Maximum stock can't be less than 1");
        }
        if (currentStock > maxStock) {
            throw new IllegalArgumentException("Current stock can't be greater than maximum stock");
        }
        this.currentStock = currentStock;
        this.maxStock = maxStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void addCurrentStock(int qty) {
        if (qty < 1) {
            throw new IllegalArgumentException("Quantity can't be less than 1");
        }
        if (currentStock + qty > maxStock) {
            throw new IllegalArgumentException("Current stock plus added quantity exceeds maximum stock");
        }
        currentStock += qty;
    }

    public void removeCurrentStock(int qty) {
        if (qty < 1) {
            throw new IllegalArgumentException("Quantity can't be less than 1");
        }
        if (currentStock - qty < 0) {
            throw new IllegalArgumentException("Attempting to remove stock that is resulting in an amount less than 0");
        }
        currentStock -= qty;
    }

}