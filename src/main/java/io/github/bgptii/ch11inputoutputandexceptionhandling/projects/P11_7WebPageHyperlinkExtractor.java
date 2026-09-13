package io.github.bgptii.ch11inputoutputandexceptionhandling.projects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads all data from a web page and prints all hyperlinks in the form: "<a href="https://example.com">TEXT</a>"
 * Follows the links that it finds and find links in those web pages as well
 */
public class P11_7WebPageHyperlinkExtractor {

    public static void main(String[] args) {
        Queue<URL> pageLocations = new LinkedList<>();
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the URL: ");
            try {
                pageLocations.add(new URL(in.nextLine().trim()));
            }
            catch (MalformedURLException e) {
                System.out.println("Invalid URL");
                return;
            }
        }

        HashSet<String> hyperlinkRepo = new HashSet<>();
        Pattern pattern = Pattern.compile("<a href=\"([^\"]+)\">.*?</a>", Pattern.CASE_INSENSITIVE); // Parentheses to create capturing group for URL
        HashSet<String> visitedPages = new HashSet<>();

        while (!pageLocations.isEmpty()) {
            URL pageLocation = pageLocations.poll();
            visitedPages.add(pageLocation.toExternalForm()); // externalForm means complete URL as a String
            try (Scanner in = new Scanner(pageLocation.openStream())) {
                while (in.hasNextLine()) {
                    String line = in.nextLine().trim();
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        hyperlinkRepo.add(matcher.group()); // Whole anchor tag
                        String urlPath = matcher.group(1); // Reference the capturing group within the pattern's parentheses (what href is referencing)
                        try {
                            URL discoveredPage = new URL(pageLocation, urlPath); // To resolve as complete path
                            String discoveredURL = discoveredPage.toExternalForm();
                            if (!visitedPages.contains(discoveredURL)) {
                                visitedPages.add(discoveredURL);
                                pageLocations.add(discoveredPage);
                            }
                        }
                        catch (MalformedURLException e) {
                            System.out.println("MALFORMED URL: " + urlPath);
                        }
                    }
                }
            }
            catch (IOException e) {
                System.out.println("Unable to parse URL " + pageLocation.getPath());
            }
        }

        for (String hyperlink : hyperlinkRepo) {
            System.out.println(hyperlink);
        }
    }

}
