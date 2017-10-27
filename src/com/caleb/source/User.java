package com.caleb.source;

public class User {
    private final String id;
    private final int pin;
    private double balance;
    public User(String id, int pin, double balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
    }
    
    public void addMoney(double money) {
        balance += money;
    }
    
    public void getMoney(double money) {
        if (money % 20 == 0) {
            balance -= money;
        }
    }

    public String getId() {
        return id;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public int getPin() {
        return pin;
    }
    

}
