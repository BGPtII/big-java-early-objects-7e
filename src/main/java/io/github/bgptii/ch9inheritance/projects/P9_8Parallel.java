package io.github.bgptii.ch9inheritance.projects;

import java.util.ArrayList;

public class P9_8Parallel extends P9_8Circuit {

    private final ArrayList<P9_8Circuit> circuits;

    public P9_8Parallel(ArrayList<P9_8Circuit> circuits) {
        this.circuits = circuits;
    }

    @Override
    public double getResistance() {
        double total = 0;
        for (P9_8Circuit circuit : circuits) {
            total += 1 / circuit.getResistance();
        }
        return 1 / total;
    }

}
