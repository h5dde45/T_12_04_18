package com.t7.p11.d4;

public class LockD {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        new DepositThread(account).start();
        System.out.println("...................");
        account.withdraw(50_000_000);
        System.out.println(account.getBalance());

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
