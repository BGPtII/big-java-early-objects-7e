package io.github.bgptii.ch12objectorienteddesign.projects;

import java.util.*;

/**
 * - Products can be purchased by inserting coins with a value at least equal to the cost of the product
 * - The coins are returned if insufficient money was supplied or if the product is sold out
 * - The machine does not give change if too much money was added
 * - Products can be restocked and money removed by an operator
 */
public class P12_1VendingMachine {

    private final Map<P12_1Coin, Integer> coinsHeld;
    private final Map<P12_1Coin, Integer> coinsInserted;
    private final Map<P12_1Product, P12_1ProductStock> stock;
    private final String managementPassword; // Just used for practicing purposes

    public P12_1VendingMachine(String managementPassword, P12_1Coin... coinsAccepted) {
        if (coinsAccepted.length < 1) {
            throw new IllegalArgumentException("Vending machine must accept at least one coin");
        }
        /*
         * - ^ start at the beginning of the string
         * - (?= positive lookahead
         * - ) end positive lookahead
         * - .* allows any number of characters before the thing we're looking for
         * - (?=...) allows to check a condition without moving the main regex forward
         * - .{8,}$
         *      - . match any character
         *      - {8,} repeat the previous thing at least 8 times
         *      - 8, at least 8 | 8,12 between 8 and 12 | 8 exactly 8
         *      - $ end of the string
         */
        if (managementPassword == null || !managementPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9\\s]).{8,}$")) {
            throw new IllegalArgumentException("Password doesn't reach complexity requires of: 8 characters minimum, at least one uppercase, lowercase, number, special character.");
        }
        this.managementPassword = managementPassword;
        coinsHeld = new HashMap<>();
        coinsInserted = new HashMap<>();
        for (P12_1Coin coin : coinsAccepted) {
            coinsHeld.put(coin, 0);
            coinsInserted.put(coin, 0);
        }
        stock = new HashMap<>();
    }

    public void stockProduct(P12_1Product p, int qty) {
        if (qty < 1) {
            throw new IllegalArgumentException("Quantity can't be less than 1");
        }
        if (!stock.containsKey(p)) {
            throw new IllegalArgumentException("Can't stock a product that hasn't been added");
        }
        else {
            P12_1ProductStock pStock = stock.get(p);
            if (qty + pStock.getCurrentStock() > pStock.getMaxStock()) {
                throw new IllegalArgumentException("Quantity exceeds maximum product stock");
            }
            pStock.addCurrentStock(qty);
        }
    }

    public void addProduct(P12_1Product p, P12_1ProductStock pStock) {
        if (stock.containsKey(p)) {
            throw new IllegalArgumentException("Stock already contains product");
        }
        stock.put(p, pStock);
    }

    public void removeProduct(P12_1Product p) {
        if (!stock.containsKey(p)) {
            throw new IllegalArgumentException("Stock doesn't contain product");
        }
        stock.remove(p);
    }

    /**
     * Purchases the specified quantity of a product. On success, coinsInserted are moved to coinsHeld and the purchased stock is removed
     * @param product product within stock
     * @param qty quantity of product
     * @return Coins if a purchase for EVERY failed purchase attempt
     */
    public Map<P12_1Coin, Integer> buyProduct(P12_1Product product, int qty) {
        if (qty < 1) {
            throw new IllegalArgumentException("Quantity can't be less than 1");
        }
        if (!stock.containsKey(product)) {
            throw new IllegalArgumentException("Vending machine doesn't have any of the specified product");
        }
        P12_1ProductStock pStock = stock.get(product);
        int coinsInsertedTotal = getInsertedCoinsTotalValue();
        int productPriceTotal = product.getCost() * qty;
        if (productPriceTotal > coinsInsertedTotal || pStock.getCurrentStock() < qty) { // Return coinsInserted here
            Map<P12_1Coin, Integer> copy = new HashMap<>(coinsInserted);
            copy.entrySet().removeIf(e -> e.getValue() == 0);
            coinsInserted.replaceAll((c, v) -> 0);
            return copy;
        }
        for (P12_1Coin c : coinsInserted.keySet()) {
            if (coinsInserted.get(c) != 0) {
                coinsHeld.put(c, coinsHeld.get(c) + coinsInserted.get(c));
                coinsInserted.put(c, 0);
            }
        }
        dispenseProduct(product, qty);
        return null;
    }

    private void dispenseProduct(P12_1Product product, int qty) {
        if (!stock.containsKey(product)) {
            throw new IllegalArgumentException("Vending machine doesn't contain product of this type");
        }
        P12_1ProductStock pStock = stock.get(product);
        if (pStock.getCurrentStock() - qty < 0) {
            throw new IllegalArgumentException("The amount of product that is being dispensed is more than the Vending Machine has stocked");
        }
        pStock.removeCurrentStock(qty);
    }

    public void insertCoin(P12_1Coin coin, int qty) {
        if (qty < 1) {
            throw new IllegalArgumentException("Quantity can't be less than 1");
        }
        if (!coinsInserted.containsKey(coin)) {
            throw new IllegalArgumentException("This vending machine does not accept coins of that type");
        }
        coinsInserted.put(coin, coinsInserted.getOrDefault(coin, 0) + qty);
    }

    public Map<P12_1Coin, Integer> removeCoinsHeld() {
        HashMap<P12_1Coin, Integer> copy = new HashMap<>(coinsHeld);
        copy.entrySet().removeIf(entry -> entry.getValue() == 0);
        coinsHeld.replaceAll((c, v) -> 0); // Safe because Integer is immutable and the copied map is a separate map
        return copy;
    }

    public Map<P12_1Coin, Integer> removeCoinsInserted() {
        HashMap<P12_1Coin, Integer> copy = new HashMap<>(coinsInserted);
        copy.entrySet().removeIf(entry -> entry.getValue() == 0);
        coinsInserted.replaceAll((c, v) -> 0); // Safe because Integer is immutable and the copied map is a separate map
        return copy;
    }

    public int getInsertedCoinsTotalValue() {
        int total = 0;
        for (P12_1Coin c : coinsInserted.keySet()) {
            total += c.getWorth() * coinsInserted.get(c);
        }
        return total;
    }

    public List<P12_1Product> getValidProducts() {
        ArrayList<P12_1Product> products = new ArrayList<>();
        for (Map.Entry<P12_1Product, P12_1ProductStock> entry : stock.entrySet()) {
            if (entry.getValue().getCurrentStock() > 0) {
                products.add(entry.getKey());
            }
        }
        return products;
    }

    public List<P12_1Product> getProducts() {
        ArrayList<P12_1Product> products = new ArrayList<>();
        for (Map.Entry<P12_1Product, P12_1ProductStock> entry : stock.entrySet()) {
            products.add(entry.getKey());
        }
        return products;
    }

    public List<P12_1Coin> getAcceptedCoins() {
        return new ArrayList<>(coinsHeld.keySet());
    }

    public int getCurrentStock(P12_1Product p) {
        if (!stock.containsKey(p)) {
            throw new IllegalArgumentException("Stock doesn't contain product");
        }
        return stock.get(p).getCurrentStock();
    }

    public int getMaxStock(P12_1Product p) {
        if (!stock.containsKey(p)) {
            throw new IllegalArgumentException("Stock doesn't contain product");
        }
        return stock.get(p).getMaxStock();
    }

    public boolean validateManagementPassword(String managementPassword) {
        // managementPassword.equals(this.managementPassword) could yield null pointer if managementPassword is null
        return this.managementPassword.equals(managementPassword);
    }

}
