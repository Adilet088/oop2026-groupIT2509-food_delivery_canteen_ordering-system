package edu.aitu.oop3.main;

import edu.aitu.oop3.model.*;

public class Main {
    public static void main(String[] args) {

        
        CustomerRepository customerRepo = new CustomerRepositoryImpl();
        MenuItemRepository menuRepo = new MenuItemRepositoryImpl();
        OrderRepository orderRepo = new OrderRepositoryImpl();

        
        MenuService menuService = new MenuService(menuRepo);
        OrderService orderService = new OrderService(orderRepo, menuService, customerRepo);

        
        System.out.println("=== AVAILABLE MENU ===");
        for (MenuItem m : menuService.getAvailableMenu()) {
            System.out.println(m.getId() + ". " + m.getName() + " - $" + m.getPrice());
        }

        
        System.out.println("\nCreating order...");
        Order order = orderService.placeOrder(1, 1, 2);

        System.out.println("Order created! ID = " + order.getId());
        System.out.println("Active orders count = " + orderService.viewActiveOrders().size());

        orderService.completeOrder(order.getId());
        System.out.println("Order completed!");
    }
}
