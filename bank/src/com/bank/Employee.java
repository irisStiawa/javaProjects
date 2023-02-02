package com.bank;

public class Employee extends Person{
    private int personalID;
    private Float salary;

    public Employee(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}
