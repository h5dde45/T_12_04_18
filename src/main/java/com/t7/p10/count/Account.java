package com.t7.p10.count;

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
        notifyAll();
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

    synchronized void withdrawAndWait(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        while (balance < amount) {
            wait();
        }
        balance -= amount;
    }

    private void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("incorrect input");
        }
    }
}
