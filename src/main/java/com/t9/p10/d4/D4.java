package com.t9.p10.d4;

public class D4 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        System.out.println("balance = " + account.getBalance());

        DepositThread depositThread = new DepositThread(account);

        depositThread.start();

        System.out.println("........");
        account.withdraw(500_000_000);

        System.out.println("end balance = " + account.getBalance());

    }

    private static class DepositThread extends Thread {
        private Account account;

        DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 600_000_000; i++) {
                account.deposit(1);
            }
        }
    }
}
