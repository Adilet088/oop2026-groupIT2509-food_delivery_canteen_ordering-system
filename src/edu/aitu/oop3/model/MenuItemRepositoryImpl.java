package edu.aitu.oop3.model;

import edu.aitu.oop3.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepositoryImpl implements MenuItemRepository {

    @Override
    public MenuItem findById(int id) {
        String sql = "SELECT id, name, price, available FROM menu_items WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                MenuItem m = new MenuItem();
                m.id = rs.getInt("id");
                m.name = rs.getString("name");
                m.price = rs.getDouble("price");
                m.available = rs.getBoolean("available");
                return m;
            }
            return null;

        } catch (Exception e) {
            throw new RuntimeException("DB error: findById menu item", e);
        }
    }

    @Override
    public List<MenuItem> findAll() {
        String sql = "SELECT id, name, price, available FROM menu_items";
        List<MenuItem> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                MenuItem m = new MenuItem();
                m.id = rs.getInt("id");
                m.name = rs.getString("name");
                m.price = rs.getDouble("price");
                m.available = rs.getBoolean("available");
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException("DB error: findAll menu items", e);
        }
    }

    @Override
    public List<MenuItem> findAvailable() {
        String sql = "SELECT id, name, price, available FROM menu_items WHERE available = true";
        List<MenuItem> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                MenuItem m = new MenuItem();
                m.id = rs.getInt("id");
                m.name = rs.getString("name");
                m.price = rs.getDouble("price");
                m.available = rs.getBoolean("available");
                list.add(m);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException("DB error: findAvailable menu items", e);
        }
    }
}