package edu.aitu.oop3.model;

import edu.aitu.oop3.exception.InvalidQuantityException;
import edu.aitu.oop3.pattern.builder.PlaceOrderRequest;
import edu.aitu.oop3.pattern.factory.DeliveryFactory;
import edu.aitu.oop3.pattern.factory.DeliveryOption;
import edu.aitu.oop3.pattern.singleton.TaxConfig;

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
        if (quantity <= 0) throw new InvalidQuantityException(quantity);

        customerRepo.findById(customerId);
        MenuItem item = menuService.requireAvailable(menuItemId);

        Order order = orderRepo.createOrder(customerId);
        orderRepo.addItem(order.id, item.id, quantity, item.price);

        return order;
    }

    public Order placeOrder(PlaceOrderRequest req) {
        if (req.getQuantity() <= 0) throw new InvalidQuantityException(req.getQuantity());

        customerRepo.findById(req.getCustomerId());
        MenuItem item = menuService.requireAvailable(req.getMenuItemId());

        DeliveryOption opt = DeliveryFactory.create(req.getDeliveryType(), req.getAddress());

        double subtotal = item.price * req.getQuantity();

        double fee = opt.fee(subtotal);

        double totalWithFee = subtotal + fee;
        double totalWithTax = TaxConfig.getInstance().addTax(totalWithFee);

        Order order = orderRepo.createOrder(req.getCustomerId());
        orderRepo.addItem(order.id, item.id, req.getQuantity(), item.price);

        System.out.println("Delivery type: " + opt.getType());
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Fee: " + fee);
        System.out.println("Tax%: " + TaxConfig.getInstance().getTaxPercent());
        System.out.println("Total: " + totalWithTax);

        return order;
    }

    public List<Order> viewActiveOrders() {
        return orderRepo.findActiveOrders();
    }

    public void completeOrder(int orderId) {
        orderRepo.markCompleted(orderId);
    }
}