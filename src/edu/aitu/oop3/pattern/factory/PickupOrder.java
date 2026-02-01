package edu.aitu.oop3.pattern.factory;

public class PickupOrder implements DeliveryOption {
    @Override
    public String getType() {
        return "PICKUP";
    }

    @Override
    public double fee(double subtotal) {
        return 0.0;
    }
}