package hr.fer.oop.recapitulation.salary;

public abstract class Worker implements SalaryCalculator {

    private String name;
    private String bankNumber;

    public Worker(String name, String bankNumber) {
        this.name = name;
        this.bankNumber = bankNumber;
    }

    public String getName() {
        return name;
    }

    public String getBankNumber() {
        return bankNumber;
    }
}
