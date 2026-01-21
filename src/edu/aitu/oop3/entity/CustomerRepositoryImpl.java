package edu.aitu.oop3.entity;

import edu.aitu.oop3.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    public CustomerRepositoryImpl() {
        customers.add(new Customer(1, "Alice"));
        customers.add(new Customer(2, "Bob"));
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}

