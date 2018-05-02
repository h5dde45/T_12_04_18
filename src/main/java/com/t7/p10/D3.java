package com.t7.p10;

public class D3 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100_000);
        System.out.println("Begin balance: " + account.getBalance());
        WithdrawThread withdrawThread = new WithdrawThread(account);
        DepositThread depositThread = new DepositThread(account);

        withdrawThread.start();
        depositThread.start();

        withdrawThread.join();
        depositThread.join();

        System.out.println("End balance: " + account.getBalance());
    }
    private static class WithdrawThread extends Thread{
        final Account account;

        private WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.withdraw(1);
            }
        }
    }
    private static class DepositThread extends Thread{
        final Account account;
        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.deposit(1);
            }
        }
    }
}

