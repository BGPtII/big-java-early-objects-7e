package io.github.bgptii.ch12objectorienteddesign.exercises;

import java.io.Serializable;

public class E12_6User implements Serializable {

    private final String username;
    private final String firstName;
    private final String lastName;

    public E12_6User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
