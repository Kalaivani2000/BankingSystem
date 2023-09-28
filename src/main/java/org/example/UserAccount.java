package org.example;

public class UserAccount {
    private String username;
    private int id;
    private double balance;

    public UserAccount(String username, int id, double initialDeposit) {
        this.username = username;
        this.id = id;
        if (initialDeposit >= 1000) {
            this.balance = initialDeposit;
        } else {
            System.out.println("Initial deposit must be at least $1000.");
        }
    }


    public void deposit(double amount) {
            System.out.println("Deposited: $" + amount);
            balance += amount;
    }

    public void withdraw(double amount) {
        System.out.println("Withdrawed: $" + amount);
        balance -= amount;
    }

    public double checkBalance() {

        return balance;
    }

    public void printAccountInfo() {
        System.out.println("Account Information:");
        System.out.println("Username: " + username);
        System.out.println("Account ID: " + id);
        System.out.println("Balance: $" + balance);
    }
}
