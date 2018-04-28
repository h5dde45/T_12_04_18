package com.t4.p1;

import javax.naming.InsufficientResourcesException;

public class Operations {
    public static void main(String[] args)
            throws InsufficientResourcesException, InterruptedException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(() -> {
            try {
                transfer(a, b, 500);
            } catch (InsufficientResourcesException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        transfer(b, a, 300);
    }

    private static void transfer(Account a, Account b, int amount)
            throws InsufficientResourcesException, InterruptedException {
        if (a.getBalance() < amount) {
            throw new InsufficientResourcesException();
        }
                System.out.println("2");
                a.withdraw(amount);
                b.deposit(amount);
    }
//    private static void transfer(Account a, Account b, int amount)
//            throws InsufficientResourcesException, InterruptedException {
//        if (a.getBalance() < amount) {
//            throw new InsufficientResourcesException();
//        }
//        synchronized (a) {
//            Thread.sleep(1111);
//            System.out.println("1 - " + Thread.currentThread());
//            synchronized (b) {
//                System.out.println("2");
//                a.withdraw(amount);
//                b.deposit(amount);
//            }
//        }
//    }
}
