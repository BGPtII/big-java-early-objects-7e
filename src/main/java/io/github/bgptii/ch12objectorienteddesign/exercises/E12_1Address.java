package io.github.bgptii.ch12objectorienteddesign.exercises;

public class E12_1Address {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    /**
     * Constructs a mailing address
     * @param name the recipient name
     * @param street the street
     * @param city the city
     * @param state the two-letter state code
     * @param zip the ZIP postal code
     */
    public E12_1Address(String name, String street, String city, String state, String zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String format() {
        return String.format("%s%n%s%n%s, %s %s", name, street, city, state, zip);
    }

}
