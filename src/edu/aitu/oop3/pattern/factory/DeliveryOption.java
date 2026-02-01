package edu.aitu.oop3.pattern.factory;

public interface DeliveryOption {
    String getType();
    double fee(double subtotal);
}