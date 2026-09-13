package io.github.bgptii.ch12objectorienteddesign.exercises;

import java.util.Scanner;

/**
 * - Text-based interface for entering and printing invoices
 * - Scanner#nextLine is needed after token-reading methods such as nextInt() and nextDouble() because they leave the newline in the input buffer
 */
public class E12_1InvoiceInterface {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        E12_1Invoice invoice = new E12_1Invoice();

        while (true) {
            System.out.println("1. Add item");
            System.out.println("2. Print invoice");
            System.out.println("3. Exit");
            int menuOpt;
            if (!in.hasNextInt() || (menuOpt = in.nextInt()) > 3 || menuOpt < 1) {
                System.out.println("Invalid option");
                in.nextLine();
                continue;
            }
            in.nextLine();
            if (menuOpt == 1) {
                String prodDesc;
                double prodPrice;
                int lineItemQty;
                System.out.print("Enter the product description: ");
                prodDesc = in.nextLine();
                if (prodDesc.isBlank()) {
                    System.out.println("Product description can't be blank");
                    continue;
                }
                System.out.print("Enter the product price: ");
                if (!in.hasNextDouble() || (prodPrice = in.nextDouble()) <= 0) {
                    System.out.println("Invalid product price");
                    in.nextLine();
                    continue;
                }
                in.nextLine();
                System.out.print("Enter the quantity: ");
                if (!in.hasNextInt() || (lineItemQty = in.nextInt()) <= 0) {
                    System.out.println("Invalid quantity");
                    in.nextLine();
                    continue;
                }
                in.nextLine();
                invoice.add(new E12_1Product(prodDesc, prodPrice), lineItemQty);
                System.out.println("Successfully added new line item");
            }
            if (menuOpt == 2) {
                System.out.println(invoice.format());
                continue;
            }
            if (menuOpt == 3) {
                System.out.println("Exiting application");
                return;
            }
        }
    }

}
