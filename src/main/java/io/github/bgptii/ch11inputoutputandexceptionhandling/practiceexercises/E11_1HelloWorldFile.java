package io.github.bgptii.ch11inputoutputandexceptionhandling.practiceexercises;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * - No need to check whether the file exists; PrintWriter will create it if it does not.
 * - Relative paths normally start from the program's working directory, which is usually
 *   the project root when running from IntelliJ.
 * - The PrintWriter fileName parameter points directly to this exercise's package folder
 *   so the generated text file stays bundled with this chapter.
 */
public class E11_1HelloWorldFile {

    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/io/github/bgptii/ch11inputoutputandexceptionhandling/practiceexercises/E11_1Hello.txt";

        PrintWriter out = new PrintWriter(fileName);
        out.println("Hello, World!");
        out.close();

        Scanner in = new Scanner(new File(fileName));
        String message = in.nextLine();
        in.close();
        System.out.println(message);
    }

}
