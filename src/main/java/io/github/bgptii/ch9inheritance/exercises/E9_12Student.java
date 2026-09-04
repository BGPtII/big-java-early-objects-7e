package io.github.bgptii.ch9inheritance.exercises;

public class E9_12Student extends E9_12Person {

    private String major;

    public E9_12Student(String name, int yearOfBirth, String major) {
        super(name, yearOfBirth);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student[name=" + getName() + ", yearOfBirth=" + getYearOfBirth() + ", major=" + major + "]";
    }

}
