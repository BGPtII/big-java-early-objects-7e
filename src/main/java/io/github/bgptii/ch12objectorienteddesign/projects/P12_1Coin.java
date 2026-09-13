package io.github.bgptii.ch12objectorienteddesign.projects;

import java.util.Objects;

public class P12_1Coin {

    private final String name;
    private final int worth;

    public P12_1Coin(String name, int worth) {
        this.name = name;
        this.worth = worth;
    }

    public String getName() {
        return name;
    }

    public int getWorth() {
        return worth;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof P12_1Coin)) {
            return false;
        }
        P12_1Coin oCoin = (P12_1Coin) o;
        return oCoin.getName().equals(getName()) && oCoin.getWorth() == getWorth();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, worth);
    }

}
