package io.github.bgptii.ch12objectorienteddesign.exercises;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

/**
 * - PBKDF2 is used because its repeated iterations make password guessing significantly slower than using a fast general-purpose hash directly
 * - E12_6Users.txt format: username:iterations$salt$hash - $ chosen as delimiter as Base64-encoded hashes don't contain $
 * - Mailbox/Sent capped at 10 emails per page
 */
public class E12_6EmailCLI {

    private static final byte INITIAL = 0;
    private static final byte LOG_IN = 1; // switch/case requires a compile-time constant for labels
    private static final byte CREATE_USER = 2;
    private static final byte MAILBOX_SELECTION = 3; // Inbox|Sent
    private static final byte INBOX = 4;
    private static final byte SENT = 5;
    private static final byte COMPOSE_MESSAGE = 6;
    private static final String CREDENTIAL_FILE_PATH = "src/main/java/io/github/bgptii/ch12objectorienteddesign/exercises/E12_6Users.txt";
    private static final String MAILBOX_FILE_PATH = "src/main/java/io/github/bgptii/ch12objectorienteddesign/exercises/E12_6Mailboxes/";
    private static final String USER_FILE_PATH = "src/main/java/io/github/bgptii/ch12objectorienteddesign/exercises/E12_6Users/";
    private static final int PBKDF2_ITERATIONS = 600000; // Work factor used for newly created password hashes
    private static final int EMAILS_PER_PAGE = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        E12_6Mailbox loggedInMailbox = null;
        E12_6User loggedInUser = null;
        int currentInboxPage = 0;
        int currentSentPage = 0;
        byte currentMenu = INITIAL;

        while (true) {
            switch (currentMenu) {
                case INITIAL:
                    {
                        System.out.println("1. Sign-In");
                        System.out.println("2. Create New Account");
                        System.out.println("3. Exit");
                        if (!in.hasNextByte()) {
                            System.out.println("Invalid option, only enter the menu option index.");
                            in.nextLine();
                            continue;
                        }
                        byte opt = in.nextByte();
                        in.nextLine();
                        if (opt < 1 || opt > 3) {
                            System.out.println("Invalid menu option index.");
                            continue;
                        }
                        if (opt == 3) {
                            System.out.println("Exiting application");
                            return;
                        }
                        currentMenu = opt;
                    }
                    break;
                case LOG_IN:
                    {
                        System.out.println("Log-In | Enter \"q\" for Main Menu");
                        System.out.print("Enter your username: ");
                        String line = in.nextLine().trim().toLowerCase();
                        if (line.equalsIgnoreCase("q")) {
                            System.out.println("Returning to Main Menu");
                            currentMenu = INITIAL;
                            continue;
                        }
                        String[] userRecord = findUserRecord(line);
                        if (userRecord == null) {
                            System.out.println("Didn't find your username: " + line);
                            continue;
                        }
                        System.out.print("Enter your password: ");
                        String[] parts = userRecord[1].split("\\$");
                        if (!validatePassword(in.nextLine(), Integer.parseInt(parts[0]), parts[1], parts[2])) {
                            System.out.println("Invalid password.");
                            continue;
                        }
                        if ((loggedInMailbox = loadMailbox(line)) == null
                                || (loggedInUser = loadUser(line)) == null) {
                            loggedInMailbox = null;
                            loggedInUser = null;
                            System.out.println("Error occurred");
                            continue;
                        }
                        System.out.println("Validated credentials, you are now logged in. Welcome " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
                        currentMenu = MAILBOX_SELECTION;
                    }
                    break;
                case CREATE_USER:
                    {
                        System.out.println("Create User | Enter \"q\" for Main Menu");
                        System.out.print("Enter your username: ");
                        String username = in.nextLine().trim().toLowerCase();
                        if (username.isEmpty()) {
                            System.out.println("Username can't be empty");
                            continue;
                        }
                        if (username.equalsIgnoreCase("q")) {
                            System.out.println("Returning to Main Menu");
                            currentMenu = INITIAL;
                            continue;
                        }
                        if (findUserRecord(username) != null) {
                            System.out.println("Username " + username + " not available");
                            continue;
                        }
                        System.out.print("Enter your first name: ");
                        String firstName = in.nextLine().trim();
                        if (firstName.isEmpty()) {
                            System.out.println("First name can't be empty");
                            continue;
                        }
                        if (firstName.equalsIgnoreCase("q")) {
                            System.out.println("Returning to Main Menu");
                            currentMenu = INITIAL;
                            continue;
                        }
                        System.out.print("Enter your last name: ");
                        String lastName = in.nextLine().trim();
                        if (lastName.isEmpty()) {
                            System.out.println("Last name can't be empty");
                            continue;
                        }
                        if (lastName.equalsIgnoreCase("q")) {
                            System.out.println("Returning to Main Menu");
                            currentMenu = INITIAL;
                            continue;
                        }
                        System.out.print("Enter your password: ");
                        String password = in.nextLine();
                        if (password.length() < 5) {
                            System.out.println("Password can't be less than 5 characters");
                            continue;
                        }
                        if (!addUserRecord(username, password)) {
                            System.out.println("Error occurred");
                            continue;
                        }
                        loggedInUser = new E12_6User(username, formatName(firstName), formatName(lastName));
                        loggedInMailbox = new E12_6Mailbox();
                        if (!saveSession(username, loggedInUser, loggedInMailbox)) {
                            System.out.println("Error occurred");
                            continue;
                        }
                        System.out.println("User successfully created, you are now logged in. Welcome " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
                        currentMenu = MAILBOX_SELECTION;
                    }
                    break;
                case MAILBOX_SELECTION:
                    {
                        System.out.println("1. Inbox");
                        System.out.println("2. Sent");
                        System.out.println("3. Compose Message");
                        System.out.println("4. Log Out");
                        System.out.println("5. Exit");
                        if (!in.hasNextByte()) {
                            System.out.println("Invalid option, only enter the menu option index.");
                            in.nextLine();
                            continue;
                        }
                        byte opt = in.nextByte();
                        in.nextLine();
                        if (opt < 1 || opt > 5) {
                            System.out.println("Invalid menu option index.");
                            continue;
                        }
                        if (opt == 1) {
                            System.out.println("Opening Inbox");
                            currentInboxPage = 0;
                            currentMenu = INBOX;
                            continue;
                        }
                        if (opt == 2) {
                            System.out.println("Opening Sent");
                            currentSentPage = 0;
                            currentMenu = SENT;
                            continue;
                        }
                        if (opt == 3) {
                            currentMenu = COMPOSE_MESSAGE;
                            continue;
                        }
                        if (opt == 4) {
                            System.out.println("Logging out");
                            if (!saveSession(loggedInUser.getUsername(), loggedInUser, loggedInMailbox)) {
                                System.out.println("Error occurred");
                                continue;
                            }
                            loggedInUser = null;
                            loggedInMailbox = null;
                            currentMenu = LOG_IN;
                            continue;
                        }
                        System.out.println("Exiting application");
                        if (!saveSession(loggedInUser.getUsername(), loggedInUser, loggedInMailbox)) {
                            System.out.println("Error occurred");
                            continue;
                        }
                        return;
                    }
                case INBOX:
                    {
                        ArrayList<E12_6Email> inbox = loggedInMailbox.getInbox();

                        int totalPages = (inbox.size() + EMAILS_PER_PAGE - 1) / EMAILS_PER_PAGE; // Round up integer division to determine page count
                        int firstEmailIndex = totalPages + 1;

                        int startIndex = firstEmailIndex + (currentInboxPage * EMAILS_PER_PAGE); // Take into account current page & emails per page
                        int endIndex = Math.min(startIndex + EMAILS_PER_PAGE, firstEmailIndex + inbox.size());
                        System.out.println("Inbox (Index. Sender | Subject | DateSent)");
                        System.out.println("0. Mailbox Selection");

                        if (inbox.isEmpty()) {
                            System.out.println("Inbox is empty, returning to Mailbox Selection");
                            currentMenu = MAILBOX_SELECTION;
                            continue;
                        }
                        for (int i = startIndex; i < endIndex; i++) {
                            int actualIndex = i - firstEmailIndex; // Adjust for current page
                            E12_6Email email = inbox.get(actualIndex);
                            System.out.println(i + ". " + email.getSender() + " | " + email.getSubject() + " | " + email.getDateSent());
                        }
                        System.out.println("Page " + (currentInboxPage + 1) + "/" + totalPages);
                        if (!in.hasNextInt()) {
                            System.out.println("Selection must be an index");
                            in.nextLine();
                            continue;
                        }
                        int opt = in.nextInt(); // email size might exceed 127, no byte
                        in.nextLine();
                        if (opt == 0) {
                            currentMenu = MAILBOX_SELECTION;
                            continue;
                        }
                        if (opt >= 1 && opt <= totalPages) { // Change pages
                            currentInboxPage = opt - 1;
                            continue;
                        }
                        if (opt >= startIndex && opt < endIndex) {
                            int actualIndex = opt - firstEmailIndex;
                            E12_6Email selectedEmail = inbox.get(actualIndex);
                            System.out.println("Sender: " + selectedEmail.getSender());
                            System.out.println("Subject: " + selectedEmail.getSubject());
                            System.out.println("DateSent: " + selectedEmail.getDateSent());
                            System.out.println(selectedEmail.getMessageText());
                        }
                        else {
                            System.out.println("Invalid index");
                        }
                    }
                    break;
                case SENT:
                    {
                        ArrayList<E12_6Email> sent = loggedInMailbox.getSent();

                        int totalPages = (sent.size() + EMAILS_PER_PAGE - 1) / EMAILS_PER_PAGE; // Round up integer division to determine page count
                        int firstEmailIndex = totalPages + 1;

                        int startIndex = firstEmailIndex + (currentSentPage * EMAILS_PER_PAGE); // Take into account current page & emails per page
                        int endIndex = Math.min(startIndex + EMAILS_PER_PAGE, firstEmailIndex + sent.size());
                        System.out.println("Sent (Index. Recipient | Subject | DateSent)");
                        System.out.println("0. Mailbox Selection");

                        if (sent.isEmpty()) {
                            System.out.println("Sent is empty, returning to Mailbox Selection");
                            currentMenu = MAILBOX_SELECTION;
                            continue;
                        }
                        for (int i = startIndex; i < endIndex; i++) {
                            int actualIndex = i - firstEmailIndex; // Adjust for current page
                            E12_6Email email = sent.get(actualIndex);
                            System.out.println(i + ". " + email.getRecipient() + " | " + email.getSubject() + " | " + email.getDateSent());
                        }
                        System.out.println("Page " + (currentSentPage + 1) + "/" + totalPages);
                        if (!in.hasNextInt()) {
                            System.out.println("Selection must be an index");
                            in.nextLine();
                            continue;
                        }
                        int opt = in.nextInt(); // email size might exceed 127, no byte
                        in.nextLine();
                        if (opt == 0) {
                            currentMenu = MAILBOX_SELECTION;
                            continue;
                        }
                        if (opt >= 1 && opt <= totalPages) { // Change pages
                            currentSentPage = opt - 1;
                            continue;
                        }
                        if (opt >= startIndex && opt < endIndex) {
                            int actualIndex = opt - firstEmailIndex;
                            E12_6Email selectedEmail = sent.get(actualIndex);
                            System.out.println("Recipient: " + selectedEmail.getRecipient());
                            System.out.println("Subject: " + selectedEmail.getSubject());
                            System.out.println("DateSent: " + selectedEmail.getDateSent());
                            System.out.println(selectedEmail.getMessageText());
                        }
                        else {
                            System.out.println("Invalid index");
                        }
                    }
                    break;
                case COMPOSE_MESSAGE:
                    System.out.println("Compose Message | Enter \"q\" for Mailbox Selection");
                    System.out.print("Recipient's username: ");
                    String recipient = in.nextLine().trim().toLowerCase();
                    if (recipient.isEmpty()) {
                        System.out.println("Recipient can't be empty");
                        continue;
                    }
                    if (recipient.equalsIgnoreCase("q")) {
                        currentMenu = MAILBOX_SELECTION;
                        continue;
                    }
                    if (findUserRecord(recipient) == null) {
                        System.out.println("Recipient " + recipient + " doesn't exist");
                        continue;
                    }
                    System.out.print("Subject line: ");
                    String subject = in.nextLine().trim();
                    if (subject.isBlank()) {
                        System.out.println("Subject can't be blank");
                        continue;
                    }
                    System.out.println("Enter message: ");
                    String message = in.nextLine().trim();
                    if (message.isBlank()) {
                        System.out.println("Message can't be blank");
                        continue;
                    }
                    if (message.length() > 300) {
                        System.out.println("Message can't exceed 300 characters");
                        continue;
                    }

                    E12_6Email email = new E12_6Email(loggedInUser.getUsername(), subject, recipient, message, LocalDateTime.now());
                    if (recipient.equals(loggedInUser.getUsername())) {
                        loggedInMailbox.addInbox(email);
                        loggedInMailbox.addSent(email);
                    }
                    else {
                        E12_6Mailbox recipientMailbox = loadMailbox(recipient);
                        if (recipientMailbox == null) {
                            System.out.println("Error loading recipient mailbox");
                            continue;
                        }
                        recipientMailbox.addInbox(email);
                        if (!saveMailbox(recipient, recipientMailbox)) {
                            System.out.println("Error delivering message");
                            continue;
                        }
                        loggedInMailbox.addSent(email);
                    }
                    System.out.println("Message successfully sent");
                    currentMenu = MAILBOX_SELECTION;
                    break;
            }
        }
    }

    private static String[] findUserRecord(String username) {
        try (Scanner fileIn = new Scanner(new File(CREDENTIAL_FILE_PATH))) {
            while (fileIn.hasNextLine()) {
                String[] parts = fileIn.nextLine().split(":", 2);
                if (username.equalsIgnoreCase(parts[0])) {
                    return parts;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    private static E12_6Mailbox loadMailbox(String username) {
        File f = new File(MAILBOX_FILE_PATH, username + ".ser");
        if (!f.exists() || !f.isFile()) {
            return null;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (E12_6Mailbox) in.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    private static E12_6User loadUser(String username) {
        File f = new File(USER_FILE_PATH, username + ".ser");
        if (!f.exists() || !f.isFile()) {
            return null;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            return (E12_6User) in.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    private static boolean addUserRecord(String username, String password) {
        try {
            byte[] salt = new byte[16]; // 128-bit salt
            new SecureRandom().nextBytes(salt); // Populate bits
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, PBKDF2_ITERATIONS, 256);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            try (PrintWriter out = new PrintWriter(new FileOutputStream(CREDENTIAL_FILE_PATH, true))) {
                out.println(username + ":" + PBKDF2_ITERATIONS + "$" + Base64.getEncoder().encodeToString(salt) + "$" + Base64.getEncoder().encodeToString(hash));
            }
            return true;
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException | FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean validatePassword(String password, int iterations, String salt, String hash) {
        try {
            // Decode back into original bytes
            byte[] saltBytes = Base64.getDecoder().decode(salt);
            byte[] storedHashBytes = Base64.getDecoder().decode(hash);

            // Recreate the same PBKDF2 calculation using the entered password - The spec packages up all the instructions that PBKDF2 needs
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, iterations, storedHashBytes.length * 8); // keyLength is in bits, hence * 8

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); // Gets the PBKDF2WithHmacSHA256 implementation

            byte[] enteredHashBytes = factory.generateSecret(spec).getEncoded(); // Performs the PBKDF2 derivation and retrieves the resulting bytes

            return MessageDigest.isEqual(enteredHashBytes, storedHashBytes); // Securely compare the newly derived hash with the stored hash
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean saveSession(String username, E12_6User user, E12_6Mailbox mailbox) {
        return saveUser(username, user) && saveMailbox(username, mailbox);
    }

    private static boolean saveMailbox(String username, E12_6Mailbox mailbox) {
        File mailboxFile = new File(MAILBOX_FILE_PATH, username + ".ser");
        try (ObjectOutputStream outMailbox = new ObjectOutputStream(new FileOutputStream(mailboxFile))) {
            outMailbox.writeObject(mailbox);
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean saveUser(String username, E12_6User user) {
        File userFile = new File(USER_FILE_PATH, username + ".ser");
        try (ObjectOutputStream outUser = new ObjectOutputStream(new FileOutputStream(userFile));) {
            outUser.writeObject(user);
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String formatName(String name) {
        name = name.trim().toLowerCase();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

}
