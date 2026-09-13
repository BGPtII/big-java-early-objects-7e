package io.github.bgptii.ch12objectorienteddesign.projects;

import java.util.Objects;

public class P12_1Product {

    private final String description;
    private final int cost;

    public P12_1Product(String description, int cost) {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof P12_1Product)) {
            return false;
        }
        P12_1Product oProduct = (P12_1Product) o;
        return oProduct.getDescription().equals(getDescription()) && oProduct.getCost() == getCost();
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, cost);
    }

}
