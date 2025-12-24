package ht.ueh.first.java;

import javax.naming.InsufficientResourcesException;

public class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Depot securise with synchronized contre les races conditions
    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Montant de depot invalide : " + amount);
        }
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " Depot " + amount);
    }
    // Retrait securise
    public synchronized void withdraw (double amount ) {
        if ( amount <= 0 ) {
            throw new InvalidAmountException("Montant de retrait invalide : " + amount);
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Fonds insuffisants (solde = " + balance + ", Retrait demande = " + amount + ")");
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + "  retrait demande : " + amount);
    }
    public synchronized double getBalance() {

        return balance;
    }
  }
