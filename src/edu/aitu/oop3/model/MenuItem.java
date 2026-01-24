package edu.aitu.oop3.model;

public class MenuItem {
    protected int id;
    protected String name;
    protected double price;
    protected boolean available;

    public MenuItem() { }

    public MenuItem(int id, String name, double price, boolean available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setAvailable(boolean available) { this.available = available; }
}
