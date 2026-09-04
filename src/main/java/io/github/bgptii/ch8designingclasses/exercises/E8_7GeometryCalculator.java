package io.github.bgptii.ch8designingclasses.exercises;

import java.util.Scanner;

public class E8_7GeometryCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        double r, h;
        if (!in.hasNextDouble() || (r = in.nextDouble()) <= 0) {
            System.out.println("Radius must be greater than 0");
            return;
        }
        System.out.print("Enter the height: ");
        if (!in.hasNextDouble() || (h = in.nextDouble()) <= 0) {
            System.out.println("Height must be greater than 0");
            return;
        }
        System.out.println("Cube volume: " + E8_7Geometry.cubeVolume(h));
        System.out.println("Cube surface area: " + E8_7Geometry.cubeSurface(h));
        System.out.println("Sphere volume: " + E8_7Geometry.sphereVolume(r));
        System.out.println("Sphere surface area: " + E8_7Geometry.sphereSurface(r));
        System.out.println("Cylinder volume: " + E8_7Geometry.cylinderVolume(r, h));
        System.out.println("Cylinder surface area: " + E8_7Geometry.cylinderSurface(r, h));
        System.out.println("Cone volume: " + E8_7Geometry.coneVolume(r, h));
        System.out.println("Cone surface area: " + E8_7Geometry.coneSurface(r, h));
    }

}
