package edu.aitu.oop3.main;

import edu.aitu.oop3.exception.*;
import edu.aitu.oop3.model.*;
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
        try {
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

        } catch (InvalidQuantityException |
                 CustomerNotFoundException |
                 MenuItemNotAvailableException |
                 OrderNotFoundException e) {
            System.out.println("MAIN FLOW ERROR: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("VALIDATION ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("UNEXPECTED ERROR: " + e.getMessage());
        }

        System.out.println("\n=== EXCEPTION TESTS ===");

        try {
            PlaceOrderRequest bad = PlaceOrderRequest.builder()
                    .customerId(1)
                    .menuItemId(1)
                    .quantity(-5)
                    .build();
            orderService.placeOrder(bad);
            System.out.println("TEST 1 FAILED");
        } catch (InvalidQuantityException | IllegalArgumentException e) {
            System.out.println("TEST 1 PASSED: " + e.getMessage());
        }

        try {
            PlaceOrderRequest bad = PlaceOrderRequest.builder()
                    .customerId(9999)
                    .menuItemId(1)
                    .quantity(1)
                    .build();
            orderService.placeOrder(bad);
            System.out.println("TEST 2 FAILED");
        } catch (CustomerNotFoundException e) {
            System.out.println("TEST 2 PASSED: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("TEST 2 PASSED (other): " + e.getMessage());
        }

        try {
            PlaceOrderRequest bad = PlaceOrderRequest.builder()
                    .customerId(1)
                    .menuItemId(9999)
                    .quantity(1)
                    .build();
            orderService.placeOrder(bad);
            System.out.println("TEST 3 FAILED");
        } catch (MenuItemNotAvailableException e) {
            System.out.println("TEST 3 PASSED: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("TEST 3 PASSED (other): " + e.getMessage());
        }

        try {
            orderService.completeOrder(9999);
            System.out.println("TEST 4 FAILED");
        } catch (OrderNotFoundException e) {
            System.out.println("TEST 4 PASSED: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("TEST 4 PASSED (other): " + e.getMessage());
        }
    }
}