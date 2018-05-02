package com.t7.p10.count;

public class D4 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        new DepositThread(account).start();
        System.out.println("1.....");
//        new WithdrawThread(account).start();
        account.withdrawAndWait(50_000_000);
        System.out.println("2...........");

    }

    private static class WithdrawThread extends Thread {
        final Account account;

        private WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            try {
                account.withdrawAndWait(50_000_000);
            } catch (InterruptedException e) {

            }
        }
    }

    private static class DepositThread extends Thread {
        final Account account;

        public DepositThread(Account account) {
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
