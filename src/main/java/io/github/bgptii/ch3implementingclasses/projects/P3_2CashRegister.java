package io.github.bgptii.ch3implementingclasses.projects;

public class P3_2CashRegister {

    private double purchase;
    private double taxablePurchase;
    private double payment;
    private int itemCount;
    private double taxRate;

    public P3_2CashRegister(double taxRate) {
        if (taxRate < 0) {
            throw new IllegalArgumentException("Tax rate cannot be negative.");
        }
        this.taxRate = taxRate;
    }

    public void recordPurchase(double amount) {
        purchase = purchase + amount;
        itemCount++;
    }

    public void recordTaxablePurchase(double amount) {
        taxablePurchase = taxablePurchase + amount;
        purchase = purchase + amount;
        itemCount++;
    }

    public void receivePayment(double amount) {
        payment = payment + amount;
    }

    public double giveChange() {
        double change = payment - purchase - getTotalTax();
        purchase = 0;
        payment = 0;
        itemCount = 0;
        taxablePurchase = 0;
        return change;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotalTax() {
        return taxablePurchase * taxRate;
    }

}
