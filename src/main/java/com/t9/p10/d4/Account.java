package com.t9.p10.d4;

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
//        notifyAll();
    }
    public synchronized void withdraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        while (balance<amount){
            wait(1000);
            System.out.println(getBalance());
        }
        balance-=amount;
    }

    private void checkAmountNonNegative(long amount) {
        if(amount<0){
            new IllegalArgumentException("negative amount");
        }
    }
}
