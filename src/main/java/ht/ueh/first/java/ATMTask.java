package ht.ueh.first.java;

public class ATMTask implements Runnable {
    public enum Action {
        DEPOSIT, WITHDRAW, BALANCE
    }

    private BankAccount account;
    private Action action;
    private double amount;

    public ATMTask(BankAccount account, Action action, double amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }

     @Override
    public void run() {
        try {
            switch (action) {

                case DEPOSIT:
                    account.deposit(amount);
                    System.out.println(Thread.currentThread().getName()  + " | depot reussi : " + amount);
                    break;

                case WITHDRAW:
                    account.withdraw(amount);
                    System.out.println(Thread.currentThread().getName() + " Retrait Reussi : " + amount);
                    break;

                case BALANCE:
                    System.out.println(Thread.currentThread().getName() + " Solde  : " + account.getBalance());
                    break;
            }
        } catch (InvalidAmountException | InsufficientFundsException e) {

            System.out.println(Thread.currentThread().getName() + " | ERREUR ( action = " + action + ", montant=" + amount + ") : " + e.getMessage());
        }
    }
}