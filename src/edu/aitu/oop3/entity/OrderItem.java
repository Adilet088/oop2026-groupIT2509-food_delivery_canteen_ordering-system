package edu.aitu.oop3.entity;

import java.util.Objects;

public class OrderItem {

    private final MenuItem menuItem;
    private final int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = Objects.requireNonNull(menuItem, "MenuItem cannot be null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (!menuItem.isAvailable()) {
            throw new IllegalStateException("Menu item is not available");
        }
        this.quantity = quantity;
    }

    protected double getTotalPrice() {
        return menuItem.getPrice() * quantity;
    }

    protected MenuItem getMenuItem() {
        return menuItem;
    }

    protected int getQuantity() {
        return quantity;
    }
}




