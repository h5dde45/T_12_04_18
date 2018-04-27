package com.t4.p1;

import javax.naming.InsufficientResourcesException;

public class Operations {
    public static void main(String[] args) throws InsufficientResourcesException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(() -> {
            try {
                transfer(a, b, 500);
            } catch (InsufficientResourcesException e) {
                e.printStackTrace();
            }
        }).start();
        transfer(b, a, 300);
    }

    private static void transfer(Account a, Account b, int amount) throws InsufficientResourcesException {
        if (a.getBalance() < amount) {
            throw new InsufficientResourcesException();
        }
        a.withdraw(amount);
        b.deposit(amount);
    }
}
