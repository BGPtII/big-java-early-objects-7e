package io.github.bgptii.ch9inheritance.projects;

public class P9_8Resistor extends P9_8Circuit {

    private final double resistance;

    public P9_8Resistor(double resistance) {
        this.resistance = resistance;
    }

    @Override
    public double getResistance() {
        return resistance;
    }

}
