package edu.aitu.oop3.pattern.factory;

public class DeliveryOrder implements DeliveryOption {
    private final String address;

    public DeliveryOrder(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String getType() {
        return "DELIVERY";
    }

    @Override
    public double fee(double subtotal) {
        return 500.0;
    }
}

