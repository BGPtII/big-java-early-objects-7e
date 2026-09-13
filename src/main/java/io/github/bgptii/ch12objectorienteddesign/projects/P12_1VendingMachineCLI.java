package io.github.bgptii.ch12objectorienteddesign.projects;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P12_1VendingMachineCLI {

    private final P12_1VendingMachine vendingMachine;
    private final Scanner in;

    public P12_1VendingMachineCLI(P12_1VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        in = new Scanner(System.in);
    }

    public void run() {
        final byte MAIN_MENU = 0;
        final byte VIEW_PRODUCTS = 1;
        final byte INSERT_COINS = 2;
        final byte MANAGEMENT_INTERFACE_LOG_IN = 3;
        final byte MANAGEMENT_INTERFACE = 4;
        byte menuOpt = MAIN_MENU;
        byte managementPasswordAttemptsRemaining = 3;
        final long MANAGEMENT_LOCKOUT_TIME = 5 * 60 * 1000L; //5m in ms
        long lockoutTimestamp = 0;
        while (true) {
            switch (menuOpt) {
                case MAIN_MENU:
                    {
                        System.out.println("Vending Machine");
                        System.out.println("1. View Products");
                        System.out.println("2. Insert Coins");
                        System.out.println("Inserted Coins Total Value: " + vendingMachine.getInsertedCoinsTotalValue());
                        System.out.println("3. Management Interface");
                        System.out.println("4. Exit ");
                        System.out.print("Menu option: ");
                        byte opt;
                        if (!in.hasNextByte() || (opt = in.nextByte()) > 4 || opt < 1) {
                            System.out.println("Invalid menu option");
                            in.nextLine();
                            continue;
                        }
                        if (opt == 4) {
                            System.out.println("Exiting Vending Machine");
                            return;
                        }
                        menuOpt = opt;
                        in.nextLine();
                    }
                    break;
                case VIEW_PRODUCTS:
                    {
                        System.out.println("Products");
                        System.out.println("0. Main Menu");
                        List<P12_1Product> products = vendingMachine.getValidProducts();
                        int i = 1;
                        for (P12_1Product p : products) {
                            System.out.println(i++ + ". " + p.getDescription() + " -" + p.getCost() + "ea | x" + vendingMachine.getCurrentStock(p));
                        }
                        System.out.print("Item to purchase: ");
                        byte opt;
                        if (!in.hasNextByte() || (opt = in.nextByte()) > products.size() || opt < 0) {
                            System.out.println("Invalid menu option");
                            in.nextLine();
                            continue;
                        }
                        in.nextLine();
                        if (opt == 0) {
                            System.out.println("Returning to Main Menu");
                            menuOpt = MAIN_MENU;
                            continue;
                        }
                        System.out.print("How many: ");
                        int qty;
                        if (!in.hasNextInt() || (qty = in.nextInt()) < 1) {
                            System.out.println("Invalid quantity");
                            in.nextLine();
                            continue;
                        }
                        in.nextLine();
                        P12_1Product product = products.get(opt - 1);
                        Map<P12_1Coin, Integer> returnedCoins = vendingMachine.buyProduct(product, qty);
                        if (returnedCoins == null) {
                            System.out.println("Successfully bought " + qty + " of " + product.getDescription());
                        }
                        else if (returnedCoins.isEmpty()) {
                            System.out.println("Purchase failed. No coins inserted");
                        }
                        else {
                            System.out.print("Purchase failed. Coins returned:");
                            for (Map.Entry<P12_1Coin, Integer> entry : returnedCoins.entrySet()) {
                                System.out.print(" " + entry.getKey().getName() + " x" + entry.getValue());
                            }
                            System.out.print("\n");
                        }
                    }
                    break;
                case INSERT_COINS:
                    {
                        System.out.println("Coins");
                        System.out.println("0. Main Menu");
                        List<P12_1Coin> coins = vendingMachine.getAcceptedCoins();
                        int i = 1;
                        for (P12_1Coin coin : coins) {
                            System.out.println(i++ + ". " + coin.getName());
                        }
                        System.out.print("Coin to insert: ");
                        int opt;
                        if (!in.hasNextInt() || (opt = in.nextInt()) < 0 || opt > coins.size()) {
                            System.out.println("Invalid coin index");
                            in.nextLine();
                            continue;
                        }
                        if (opt == 0) {
                            System.out.println("Returning to Main Menu");
                            menuOpt = MAIN_MENU;
                            continue;
                        }
                        System.out.print("Enter quantity: ");
                        int qty;
                        if (!in.hasNextInt() || (qty = in.nextInt()) < 1) {
                            System.out.println("Invalid quantity");
                            in.nextLine();
                            continue;
                        }
                        in.nextLine();
                        vendingMachine.insertCoin(coins.get(opt - 1), qty);
                    }
                    break;
                case MANAGEMENT_INTERFACE_LOG_IN:
                    {
                        if (System.currentTimeMillis() < lockoutTimestamp + MANAGEMENT_LOCKOUT_TIME) {
                            System.out.println("Locked out, returning to Main Menu");
                            menuOpt = MAIN_MENU;
                            continue;
                        }
                        else if (managementPasswordAttemptsRemaining == 0) {
                            managementPasswordAttemptsRemaining = 3;
                            lockoutTimestamp = 0;
                        }
                        System.out.println("Attempts until lockout: " + managementPasswordAttemptsRemaining);
                        System.out.print("Enter management password (\"q\" for Main Menu): ");
                        String s = in.nextLine();
                        if (s.equalsIgnoreCase("q")) {
                            System.out.println("Returning to Main Menu");
                            menuOpt = MAIN_MENU;
                            continue;
                        }
                        if (!vendingMachine.validateManagementPassword(s)) {
                            System.out.println("Invalid password");
                            if (--managementPasswordAttemptsRemaining == 0) {
                                lockoutTimestamp = System.currentTimeMillis();
                                System.out.println("Locked out");
                            }
                            continue;
                        }
                        managementPasswordAttemptsRemaining = 3;
                        menuOpt = MANAGEMENT_INTERFACE;
                    }
                    break;
                case MANAGEMENT_INTERFACE:
                    {
                        System.out.println("Management Interface");
                        System.out.println("0. Log Out");
                        System.out.println("1. Withdraw coins");
                        System.out.println("2. Add product");
                        System.out.println("3. Restock product");
                        System.out.print("Menu option: ");
                        byte opt;
                        if (!in.hasNextByte() || (opt = in.nextByte()) > 3 || opt < 0) {
                            System.out.println("Invalid menu option");
                            in.nextLine();
                            continue;
                        }
                        if (opt == 0) {
                            System.out.println("Logging out");
                            menuOpt = MAIN_MENU;
                            continue;
                        }
                        in.nextLine();
                        if (opt == 1) {
                            Map<P12_1Coin, Integer> coinsRemoved = vendingMachine.removeCoinsHeld();
                            System.out.print("Coins removed:");
                            int totalValue = 0;
                            if (coinsRemoved.isEmpty()) {
                                System.out.print(" none\n");
                            }
                            else {
                                for (Map.Entry<P12_1Coin, Integer> e : coinsRemoved.entrySet()) {
                                    totalValue += e.getValue() * e.getKey().getWorth();
                                    System.out.print(" " + e.getKey().getName() + " x" + e.getValue());
                                }
                                System.out.print("\n");
                            }
                            System.out.println("Total value of coins removed: " + totalValue);
                        }
                        if (opt == 2) {
                            System.out.print("Enter the product name: ");
                            String description = in.nextLine();
                            if (description.isBlank()) {
                                System.out.println("Product name can't be blank");
                                continue;
                            }
                            System.out.print("Enter cost: ");
                            int cost;
                            if (!in.hasNextInt() || (cost = in.nextInt()) < 0) {
                                System.out.println("Invalid cost");
                                in.nextLine();
                                continue;
                            }
                            in.nextLine();
                            P12_1Product newProduct = new P12_1Product(description, cost);
                            int maxQty;
                            System.out.print("Enter max quantity: ");
                            if (!in.hasNextInt() || (maxQty = in.nextInt()) < 1) {
                                System.out.println("Invalid max quantity");
                                in.nextLine();
                                continue;
                            }
                            in.nextLine();
                            int currentQty;
                            System.out.print("Enter initial/current quantity: ");
                            if (!in.hasNextInt() || (currentQty = in.nextInt()) < 0 || currentQty > maxQty) {
                                System.out.println("Invalid current quantity");
                                in.nextLine();
                                continue;
                            }
                            in.nextLine();
                            P12_1ProductStock newProductStock = new P12_1ProductStock(currentQty, maxQty);
                            vendingMachine.addProduct(newProduct, newProductStock);
                            System.out.println("Product successfully added");
                        }
                        if (opt == 3) {
                            System.out.println("Products");
                            System.out.println("0. Main Menu");
                            List<P12_1Product> products = vendingMachine.getProducts();
                            int i = 1;
                            for (P12_1Product p : products) {
                                System.out.println(i++ + ". " + p.getDescription() + " | Current stock: " + vendingMachine.getCurrentStock(p) + " | Max stock: " + vendingMachine.getMaxStock(p));
                            }
                            System.out.print("Product to restock: ");
                            int reStockOpt;
                            if (!in.hasNextInt() || (reStockOpt = in.nextInt()) > products.size() || reStockOpt < 0) {
                                System.out.println("Invalid menu option");
                                in.nextLine();
                                continue;
                            }
                            in.nextLine();
                            if (reStockOpt == 0) {
                                System.out.println("Returning to Main Menu");
                                menuOpt = MAIN_MENU;
                                continue;
                            }
                            int maxStock = vendingMachine.getMaxStock(products.get(reStockOpt - 1));
                            int currentStock = vendingMachine.getCurrentStock(products.get(reStockOpt - 1));
                            System.out.print("Enter stock units added: (max: " + (maxStock - currentStock) + "): ");
                            int addedUnits;
                            if (!in.hasNextInt() || (addedUnits = in.nextInt()) < 1 || maxStock < currentStock + addedUnits) {
                                System.out.println("Invalid quantity for units added");
                                in.nextLine();
                                continue;
                            }
                            in.nextLine();
                            vendingMachine.stockProduct(products.get(reStockOpt - 1), addedUnits);
                            System.out.println("Successfully added new stock");
                        }
                    }
                    break;
            }
        }
    }

}
