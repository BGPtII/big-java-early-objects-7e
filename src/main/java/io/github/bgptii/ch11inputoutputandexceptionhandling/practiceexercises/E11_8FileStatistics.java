package io.github.bgptii.ch11inputoutputandexceptionhandling.practiceexercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E11_8FileStatistics {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String filePath;
        System.out.print("Enter the full path of the file: ");
        filePath = in.nextLine();
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }
        if (!file.isFile()) {
            System.out.println("Path does not point to a file");
            return;
        }
        if (!file.canRead()) {
            System.out.println("File cannot be read.");
            return;
        }
        in.close();

        int numChars = 0, numWords = 0, numLines = 0;
        in = new Scanner(file);
        while (in.hasNextLine()) {
            numLines++;
            String line = in.nextLine();
            numChars += line.length();
            if (!line.isBlank()) {
                numWords += line.trim().split("\\s+").length;
            }
        }
        in.close();
        System.out.println("Number of characters: " + numChars);
        System.out.println("Number of words: " + numWords);
        System.out.println("Number of lines: " + numLines);
    }

}
