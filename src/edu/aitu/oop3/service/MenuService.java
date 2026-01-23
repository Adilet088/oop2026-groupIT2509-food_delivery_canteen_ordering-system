package edu.aitu.oop3.service;

import edu.aitu.oop3.entity.MenuItem;
import java.util.List;

public class MenuService {

    public List<MenuItem> getMenu() {
        return List.of(
                new MenuItem(1, "Burger", 5.0, true),
                new MenuItem(2, "Fries", 2.5, true),
                new MenuItem(3, "Soda", 1.5, false),       // unavailable
                new MenuItem(4, "Pizza", 8.0, true),
                new MenuItem(5, "Salad", 4.0, true),
                new MenuItem(6, "Ice Cream", 3.0, true),
                new MenuItem(7, "Coffee", 2.0, true),
                new MenuItem(8, "Tea", 1.5, false),        // unavailable
                new MenuItem(9, "Chicken Wings", 6.5, true),
                new MenuItem(10, "Pasta", 7.0, true)
        );
    }
}
