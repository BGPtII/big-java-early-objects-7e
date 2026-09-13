package io.github.bgptii.ch11inputoutputandexceptionhandling.practiceexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class E11_2TxtBlankLineRemover {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the full path of the text file: ");
        String filePath = in.nextLine();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        if (!file.isFile()) {
            System.out.println("Is not a file.");
            return;
        }
        if (!file.getName().toLowerCase().endsWith(".txt")) {
            System.out.println("Not a .txt file.");
            return;
        }
        in.close();

        ArrayList<String> nonBlankLines = new ArrayList<>();
        in = new Scanner(file);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (!line.isBlank()) {
                nonBlankLines.add(line);
            }
        }
        in.close();

        PrintWriter out = new PrintWriter(file);
        for (String line : nonBlankLines) {
            out.println(line);
        }
        out.close();
    }

}
