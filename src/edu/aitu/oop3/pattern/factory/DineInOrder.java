package edu.aitu.oop3.pattern.factory;

public class DineInOrder implements DeliveryOption {
    @Override
    public String getType() {
        return "DINEIN";
    }

    @Override
    public double fee(double subtotal) {
        return subtotal * 0.05;
    }
}

