package edu.aitu.oop3.entity;

public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected int getId() {
        return id;
    }

    protected String getName() {
        return name;
    }
}
