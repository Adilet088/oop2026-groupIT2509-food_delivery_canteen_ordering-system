package edu.aitu.oop3.pattern.factory;

public class DeliveryFactory {

    public static DeliveryOption create(String type, String address) {
        if (type == null) return new PickupOrder();

        switch (type.toUpperCase()) {
            case "DELIVERY":
                return new DeliveryOrder(address);
            case "DINEIN":
                return new DineInOrder();
            case "PICKUP":
            default:
                return new PickupOrder();
        }
    }
}

