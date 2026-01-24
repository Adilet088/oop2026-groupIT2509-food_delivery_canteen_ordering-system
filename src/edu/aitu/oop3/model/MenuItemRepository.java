package edu.aitu.oop3.model;

import java.util.List;

public interface MenuItemRepository {
    MenuItem findById(int id);
    List<MenuItem> findAll();
    List<MenuItem> findAvailable();
}