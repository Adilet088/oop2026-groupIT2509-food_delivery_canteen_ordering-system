package edu.aitu.oop3.model;

public class OrderItem {
    protected int id;
    protected int orderId;
    protected int menuItemId;
    protected int quantity;
    protected double priceAtOrder;

    public OrderItem() { }

    public int getId() { return id; }
    public int getOrderId() { return orderId; }
    public int getMenuItemId() { return menuItemId; }
    public int getQuantity() { return quantity; }
    public double getPriceAtOrder() { return priceAtOrder; }

    public void setId(int id) { this.id = id; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setMenuItemId(int menuItemId) { this.menuItemId = menuItemId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPriceAtOrder(double priceAtOrder) { this.priceAtOrder = priceAtOrder; }
}





