package com.t9.p10.d3;

public class D3 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100_000);
        System.out.println("balance = " + account.getBalance());

        WithdrawThread withdrawThread = new WithdrawThread(account);
        DepositThread depositThread = new DepositThread(account);

        withdrawThread.start();
        depositThread.start();

        withdrawThread.join();
        depositThread.join();

        System.out.println("end balance = " + account.getBalance());

    }

    private static class WithdrawThread extends Thread {
        private Account account;

        WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                account.withdraw(1);
            }
        }
    }

    private static class DepositThread extends Thread{
        private Account account;

        DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_000; i++) {
                account.deposit(1);
            }
        }
    }
}
