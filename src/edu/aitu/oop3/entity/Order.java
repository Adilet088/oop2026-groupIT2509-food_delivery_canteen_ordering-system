package edu.aitu.oop3.entity;

import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> items;
    private boolean completed;

    public Order(int id, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.completed = false;
    }

    protected int getId() {
        return id;
    }

    protected Customer getCustomer() {
        return customer;
    }

    protected List<OrderItem> getItems() {
        return items;
    }

    protected boolean isCompleted() {
        return completed;
    }

    protected void markCompleted() {
        this.completed = true;
    }

    protected double getTotalPrice() {
        return items.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }
}

