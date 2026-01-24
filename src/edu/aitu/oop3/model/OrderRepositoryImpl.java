package edu.aitu.oop3.model;

import edu.aitu.oop3.db.DatabaseConnection;
import edu.aitu.oop3.exception.OrderNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public Order createOrder(int customerId) {

        String sql = "INSERT INTO orders(customer_id, status) VALUES (?, 'ACTIVE') RETURNING id, order_date";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, customerId);
            ResultSet rs = st.executeQuery();
            rs.next();

            Order o = new Order();
            o.id = rs.getInt("id");
            o.customerId = customerId;
            o.status = "ACTIVE";

            Timestamp ts = rs.getTimestamp("order_date");
            o.orderDate = ts.toLocalDateTime();

            return o;

        } catch (Exception e) {
            throw new RuntimeException("DB error: create order", e);
        }
    }

    @Override
    public void addItem(int orderId, int menuItemId, int quantity, double priceAtOrder) {
        // important: price_at_order matches your SQL column name
        String sql = "INSERT INTO order_items(order_id, menu_item_id, quantity, price_at_order) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, orderId);
            st.setInt(2, menuItemId);
            st.setInt(3, quantity);
            st.setDouble(4, priceAtOrder);

            st.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("DB error: add order item", e);
        }
    }

    @Override
    public List<Order> findActiveOrders() {
        String sql = "SELECT id, customer_id, status, order_date FROM orders WHERE status = 'ACTIVE'";
        List<Order> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                Order o = new Order();
                o.id = rs.getInt("id");
                o.customerId = rs.getInt("customer_id");
                o.status = rs.getString("status");

                Timestamp ts = rs.getTimestamp("order_date");
                o.orderDate = ts.toLocalDateTime();

                list.add(o);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException("DB error: find active orders", e);
        }
    }

    @Override
    public void markCompleted(int orderId) {
        String sql = "UPDATE orders SET status = 'COMPLETED' WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, orderId);
            int updated = st.executeUpdate();

            if (updated == 0) {
                throw new OrderNotFoundException("Order not found: " + orderId);
            }

        } catch (OrderNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("DB error: mark completed", e);
        }
    }
}