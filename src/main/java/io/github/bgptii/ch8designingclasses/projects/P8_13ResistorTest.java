package io.github.bgptii.ch8designingclasses.projects;

public class P8_13ResistorTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            P8_13Resistor resistor = new P8_13Resistor(330, 10);
            System.out.println(resistor.getActualResistance());
        }
    }

}
