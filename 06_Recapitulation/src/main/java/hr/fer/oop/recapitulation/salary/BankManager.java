package hr.fer.oop.recapitulation.salary;

public class BankManager {

    public void payment(Worker worker, double amount) {
        System.out.println(worker.getName() + " - " + worker.getBankNumber() + ": " + amount);
    }
}
