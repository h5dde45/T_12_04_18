package com.t9.p11.d4;

public class LockD4 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        System.out.println("balance = " + account.getBalance());

        new DepositThread(account).start();

        System.out.println("........");
        account.withdraw(50_000_000);

        System.out.println("end balance = " + account.getBalance());

    }

    private static class DepositThread extends Thread {
        private Account account;

        DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 60_000_000; i++) {
                account.deposit(1);
            }
        }
    }
}
