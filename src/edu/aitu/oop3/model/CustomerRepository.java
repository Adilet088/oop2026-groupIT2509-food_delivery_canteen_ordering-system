package edu.aitu.oop3.model;

import java.util.List;

public interface CustomerRepository {
    Customer findById(int id);
    List<Customer> findAll();
}
