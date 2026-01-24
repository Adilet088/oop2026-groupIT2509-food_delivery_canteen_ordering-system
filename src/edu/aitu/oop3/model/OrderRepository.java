package edu.aitu.oop3.model;

import java.util.List;

public interface OrderRepository {
    Order createOrder(int customerId);
    void addItem(int orderId, int menuItemId, int quantity, double priceAtOrder);
    List<Order> findActiveOrders();
    void markCompleted(int orderId);
}

