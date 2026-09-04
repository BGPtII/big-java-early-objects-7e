package io.github.bgptii.ch4fundamentaldatatypes.exercises;

/**
 * displays the properties of a letter-size (8.5 × 11 inches) sheet of
 * paper in millimeters. There are 25.4 millimeters per inch.
 * Needs to use constants and comments.
 */
public class E4_1LetterSizePaperProperties {

    public static void main(String[] args) {
        // Define constants
        final double PAPER_WIDTH_INCHES = 8.5;
        final double PAPER_HEIGHT_INCHES = 11;
        final double MILLIMETERS_PER_INCH = 25.4;

        // Calculate converted dimensions
        double widthMM = PAPER_WIDTH_INCHES * MILLIMETERS_PER_INCH;
        double heightMM = PAPER_HEIGHT_INCHES * MILLIMETERS_PER_INCH;

        // Calculate perimeter, area, diagonal
        double perimeter = widthMM * 2 + heightMM * 2;
        double area = widthMM * heightMM;
        double lengthOfDiagonal = Math.sqrt(Math.pow(widthMM, 2) + Math.pow(heightMM, 2));
        System.out.println("Height: " + heightMM + ", width: " + widthMM + ", perimeter: " + perimeter + ", area: " + area + ", length of diagonal: " + lengthOfDiagonal);
    }
}
