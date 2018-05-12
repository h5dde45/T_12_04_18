package com.t9.p10.d3;

public class Account {
    private long balance;

    public Account() {
        this(0);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }
    public synchronized void deposit(long amount){
        checkAmountNonNegative(amount);
        balance+=amount;
    }
    public synchronized void withdraw(long amount){
        checkAmountNonNegative(amount);
        if(balance<amount){
            new IllegalArgumentException("insufficient funds for withdrawal");
        }
        balance-=amount;
    }

    private void checkAmountNonNegative(long amount) {
        if(amount<0){
            new IllegalArgumentException("negative amount");
        }
    }
}
