package io.github.bgptii.ch11inputoutputandexceptionhandling.projects;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class P11_3WebPageToFile {

    public static void main(String[] args) throws IOException {
        URL pageLocation;
        File outputFile;
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the URL: ");
            try {
                pageLocation = new URL(in.nextLine().trim());
            }
            catch (MalformedURLException e) {
                System.out.println("Invalid URL");
                return;
            }

            System.out.print("Enter the output file (FULL PATH): ");
            outputFile = new File(in.nextLine().trim());
            if (outputFile.exists()) {
                System.out.println("Output file already exists");
                return;
            }
        }

        try (
                Scanner in = new Scanner(pageLocation.openStream());
                PrintWriter out = new PrintWriter(outputFile)) {
            while (in.hasNextLine()) {
                out.println(in.nextLine());
            }
        }
    }

}
