package com.t7.p10;

public class Account {
    private long balance;

    public Account() {
        this(0);
    }

    Account(long balance) {
        this.balance = balance;
    }

    long getBalance() {
        return balance;
    }

    synchronized void deposit(long amount) {
        checkAmountNonNegative(amount);
        balance += amount;
    }

    /*synchronized*/ void withdraw(long amount) {
        checkAmountNonNegative(amount);
        synchronized (this) {
            if (balance < amount) {
            throw new IllegalArgumentException("insufficient money to withdraw");
        }
            balance -= amount;
        }
    }

    private void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("incorrect input");
        }
    }
}
