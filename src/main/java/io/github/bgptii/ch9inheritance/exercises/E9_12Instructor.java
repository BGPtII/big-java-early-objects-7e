package io.github.bgptii.ch9inheritance.exercises;

public class E9_12Instructor extends E9_12Person {

    private double salary;

    public E9_12Instructor(String name, int yearOfBirth, double salary) {
        super(name, yearOfBirth);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Instructor[name=" + getName() + ", yearOfBirth=" + getYearOfBirth() + ", salary=" + salary + "]";
    }

}
