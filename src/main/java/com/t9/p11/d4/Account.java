package com.t9.p11.d4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private long balance;
    private final Lock lock = new ReentrantLock();
    private final Condition balanceIncreased = lock.newCondition();
    ;

    public Account() {
        this(0);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            balance += amount;
            balanceIncreased.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        lock.lock();
        try {
            while (balance < amount) {
                balanceIncreased.await();
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    private void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            new IllegalArgumentException("negative amount");
        }
    }
}
