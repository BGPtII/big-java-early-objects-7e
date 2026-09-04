package io.github.bgptii.ch9inheritance.exercises;

public class E9_12Person {

    private String name;
    private int yearOfBirth;

    public E9_12Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", yearOfBirth=" + yearOfBirth + "]";
    }

}
