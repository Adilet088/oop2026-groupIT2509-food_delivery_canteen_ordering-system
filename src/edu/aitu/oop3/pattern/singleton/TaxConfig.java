package edu.aitu.oop3.pattern.singleton;

public final class TaxConfig {
    private static final TaxConfig INSTANCE = new TaxConfig();


    private double taxPercent = 12.0;

    private TaxConfig() {}

    public static TaxConfig getInstance() {
        return INSTANCE;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        if (taxPercent < 0) taxPercent = 0;
        this.taxPercent = taxPercent;
    }

    public double addTax(double amount) {
        return amount + (amount * taxPercent / 100.0);
    }
}