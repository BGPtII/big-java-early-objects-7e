package io.github.bgptii.ch9inheritance.exercises;

public class E9_1Manager extends E9_1Employee {

    private double salaryBonus;

    public E9_1Manager(String name, double baseSalary, double salaryBonus) {
        super(name, baseSalary);
        this.salaryBonus = salaryBonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + salaryBonus;
    }

    public void setSalaryBonus(double salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

}
