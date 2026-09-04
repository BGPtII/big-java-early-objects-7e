package io.github.bgptii.ch3implementingclasses.projects;

public class P3_1CashRegister {

    private double purchase;
    private double payment;
    private int itemCount;

    public P3_1CashRegister() {

    }

    public void recordPurchase(double amount) {
        purchase = purchase + amount;
        itemCount++;
    }

    public void receivePayment(double amount) {
        payment = payment + amount;
    }

    public double giveChange() {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        itemCount = 0;
        return change;
    }

    public int getItemCount() {
        return itemCount;
    }

}

