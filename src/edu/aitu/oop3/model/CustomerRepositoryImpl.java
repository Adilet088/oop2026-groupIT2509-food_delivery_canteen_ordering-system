package edu.aitu.oop3.model;

import edu.aitu.oop3.db.DatabaseConnection;
import edu.aitu.oop3.exception.CustomerNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findById(int id) {
        String sql = "SELECT id, name, email FROM customers WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Customer c = new Customer();
                c.id = rs.getInt("id");
                c.name = rs.getString("name");
                c.email = rs.getString("email");
                return c;
            }

            throw new CustomerNotFoundException("Customer not found: " + id);

        } catch (CustomerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("DB error: findById customer", e);
        }
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT id, name, email FROM customers";
        List<Customer> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Customer c = new Customer();
                c.id = rs.getInt("id");
                c.name = rs.getString("name");
                c.email = rs.getString("email");
                list.add(c);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException("DB error: findAll customers", e);
        }
    }
}

