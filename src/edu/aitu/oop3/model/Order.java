package edu.aitu.oop3.model;

import java.time.LocalDateTime;

public class Order {
    protected int id;
    protected int customerId;
    protected String status;
    protected LocalDateTime orderDate;

    public Order() { }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public String getStatus() { return status; }
    public LocalDateTime getOrderDate() { return orderDate; }

    public void setId(int id) { this.id = id; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setStatus(String status) { this.status = status; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
}


