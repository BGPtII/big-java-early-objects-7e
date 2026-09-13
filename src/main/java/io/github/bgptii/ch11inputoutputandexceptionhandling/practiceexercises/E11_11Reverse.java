package io.github.bgptii.ch11inputoutputandexceptionhandling.practiceexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Replaces each line of a file with its reverse. For example, you run "java Reverse HelloPrinter.java" it replaces
 * the file's lines with its reverse
 */
public class E11_11Reverse {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Only 1 argument required");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist");
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException("Argument does not point to a file");
        }
        if (!file.canRead()) {
            throw new IllegalArgumentException("File cannot be read");
        }
        if (!file.canWrite()) {
            throw new IllegalArgumentException("File cannot be written to");
        }

        ArrayList<String> reversedLines = new ArrayList<>();
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String reverse = "";
                for (int i = line.length() - 1; i >= 0; i--) {
                    reverse += line.charAt(i);
                }
                reversedLines.add(reverse);
            }
        }

        try (PrintWriter out = new PrintWriter(file)) {
            for (String reversedLine : reversedLines) {
                out.println(reversedLine);
            }
        }
    }

}
