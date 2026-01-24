package edu.aitu.oop3.model;

import edu.aitu.oop3.exception.InvalidQuantityException;

import java.util.List;

public class OrderService {

    private OrderRepository orderRepo;
    private MenuService menuService;
    private CustomerRepository customerRepo;

    public OrderService(OrderRepository orderRepo, MenuService menuService, CustomerRepository customerRepo) {
        this.orderRepo = orderRepo;
        this.menuService = menuService;
        this.customerRepo = customerRepo;
    }

    public Order placeOrder(int customerId, int menuItemId, int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be > 0");
        }

        customerRepo.findById(customerId);

        MenuItem item = menuService.requireAvailable(menuItemId);

        Order order = orderRepo.createOrder(customerId);
        orderRepo.addItem(order.id, item.id, quantity, item.price);

        return order;
    }

    public List<Order> viewActiveOrders() {
        return orderRepo.findActiveOrders();
    }

    public void completeOrder(int orderId) {
        orderRepo.markCompleted(orderId);
    }
}

