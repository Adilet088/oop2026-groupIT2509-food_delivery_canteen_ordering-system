package edu.aitu.oop3.main;

import edu.aitu.oop3.model.*;
import edu.aitu.oop3.exception.InvalidQuantityException;
import edu.aitu.oop3.pattern.builder.PlaceOrderRequest;
import edu.aitu.oop3.pattern.singleton.TaxConfig;

public class Main {
    public static void main(String[] args) {

        CustomerRepository customerRepo = new CustomerRepositoryImpl();
        MenuItemRepository menuRepo = new MenuItemRepositoryImpl();
        OrderRepository orderRepo = new OrderRepositoryImpl();

        MenuService menuService = new MenuService(menuRepo);
        OrderService orderService = new OrderService(orderRepo, menuService, customerRepo);

        TaxConfig.getInstance().setTaxPercent(12.0);

        System.out.println("=== AVAILABLE MENU ===");
        for (MenuItem m : menuService.getAvailableMenu()) {
            System.out.println(m.getId() + ". " + m.getName() + " - " + m.getPrice());
        }

        System.out.println("\n=== PLACE ORDER (BUILDER + FACTORY + SINGLETON) ===");

        PlaceOrderRequest req = PlaceOrderRequest.builder()
                .customerId(1)
                .menuItemId(1)
                .quantity(2)
                .deliveryType("DELIVERY")
                .address("Astana, Mangilik El")
                .build();

        Order order = orderService.placeOrder(req);
        System.out.println("Order created! ID = " + order.getId());

        System.out.println("Active orders count = " + orderService.viewActiveOrders().size());

        orderService.completeOrder(order.getId());
        System.out.println("Order completed!");

        System.out.println("\n=== EXCEPTION TEST ===");
        try {
            PlaceOrderRequest bad = PlaceOrderRequest.builder()
                    .customerId(1)
                    .menuItemId(1)
                    .quantity(-5)
                    .build();
            orderService.placeOrder(bad);
        } catch (IllegalArgumentException | InvalidQuantityException e) {
            System.out.println("TEST PASSED: " + e.getMessage());
        }
    }
}