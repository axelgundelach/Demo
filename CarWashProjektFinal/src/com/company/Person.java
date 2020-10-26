package com.company;

public class Person {
    // Person
    private String name;
    double balance;

    public Person(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public double changeBalance(double newBalance){
        this.balance = newBalance;
        return newBalance;
    }

    public String toString(){
        return this.name + " with the balance : " + this.balance;
    }
}