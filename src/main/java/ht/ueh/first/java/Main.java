package ht.ueh.first.java;
public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(999, 1000);

        //  Retrait valide
        Thread t1 = new Thread(
                new ATMTask(account, ATMTask.Action.WITHDRAW, 400),
                "Client-1"
        );

        //  Retrait avec Fond insuffisants
        Thread t2 = new Thread(
                new ATMTask(account, ATMTask.Action.WITHDRAW, 1000),
                "Client-2"
        );

        //Depot invalide
        Thread t3 = new Thread(
                new ATMTask(account, ATMTask.Action.DEPOSIT, -100),
                "Client-3"
        );

        // Consultation du solde
        Thread t4 = new Thread(
                new ATMTask(account, ATMTask.Action.BALANCE, 0),
                "Client-4"
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
   // Me Amosse, desolee pour le retard de la partie 6, dut a des difficultes lors de la realisation avec mon intellij.