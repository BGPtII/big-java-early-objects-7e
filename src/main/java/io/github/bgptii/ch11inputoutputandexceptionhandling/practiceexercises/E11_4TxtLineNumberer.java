package io.github.bgptii.ch11inputoutputandexceptionhandling.practiceexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class E11_4TxtLineNumberer {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the full path of the .txt file: ");
        String inputFilePath = in.nextLine();
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            System.out.println("File does not exist");
            return;
        }
        if (!inputFile.isFile()) {
            System.out.println("Is not a file.");
            return;
        }
        if (!inputFile.getName().toLowerCase().endsWith(".txt")) {
            System.out.println("Not a .txt file.");
            return;
        }
        System.out.println();
        System.out.print("Enter the full path of the output file ending in .txt (EX: \"C:/test.txt\"): ");
        String outputFilePath = in.nextLine();
        File outputFile = new File(outputFilePath);
        if (outputFile.exists()) {
            System.out.println("Output file already exists");
            return;
        }
        if (!outputFile.getName().toLowerCase().endsWith(".txt")) {
            System.out.println("Not a .txt file.");
            return;
        }
        in.close();

        ArrayList<String> numberedLines = new ArrayList<>();
        in = new Scanner(inputFile);
        int lineNumber = 1;
        while (in.hasNextLine()) {
            numberedLines.add("/* " + lineNumber++ + " */ " + in.nextLine());
        }
        in.close();

        PrintWriter out = new PrintWriter(outputFile);
        for (String line : numberedLines) {
            out.println(line);
        }
        out.close();
    }

}
