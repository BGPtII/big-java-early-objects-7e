package io.github.bgptii.ch8designingclasses.exercises;

public class E8_1CashRegister {

    private double payment;

    public void receivePayment(int coinCount, E8_1Coin coinType) {
        if (coinType == null) {
            throw new IllegalArgumentException("Coin type cannot be null.");
        }
        if (coinCount < 0) {
            throw new IllegalArgumentException("Coin count cannot be negative.");
        }
        payment += coinCount * coinType.getValue();
    }

}
