package edu.aitu.oop3.entity;

public class MenuItem {
    private int id;
    private String name;
    private double price;
    private boolean available;

    public MenuItem(int id, String name, double price, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
    }

    protected int getId() {
        return id;
    }

    protected String getName() {
        return name;
    }

    protected double getPrice() {
        return price;
    }

    protected boolean isAvailable() {
        return available;
    }
}
