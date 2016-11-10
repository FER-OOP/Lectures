package hr.fer.oop.topic11.example5;

import com.erp.ExchangeRateProvider;

public class CHFCalculator {

    private final ExchangeRateProvider erp;

    public CHFCalculator(ExchangeRateProvider erp) {
        this.erp = erp;
    }

    public double chfToHrk(double amountOfChfs) {
        return amountOfChfs * erp.getRate("CHF", "HRK");
    }

    public double hrkToChf(double amountOfHrks) {
        return amountOfHrks * erp.getRate("HRK", "CHF");
    }
    
    public void printRates() {
        erp.printRates();
    }
}
