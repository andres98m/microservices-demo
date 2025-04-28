package com.example.order_service.service;

import com.example.order_service.delegate.OrderDelegate;
import com.example.order_service.model.CreateOrderDTO;
import com.example.order_service.model.Order;
import com.example.order_service.model.Product;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDelegate orderDelegate;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderDelegate orderDelegate) {
        this.orderRepository = orderRepository;
        this.orderDelegate = orderDelegate;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Product getProductById(String productId) {
        return orderDelegate.getProduct(productId);
    }

    public Order createOrder(CreateOrderDTO order) {
        Product product = orderDelegate.getProduct(order.getProductId());
        if (product == null || product.getStock() < order.getQuantity()) {
            throw new RuntimeException("Product not found");
        }

        double totalPrice = product.getPrice() * order.getQuantity();

        Order newOrder = Order.builder()
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .totalPrice(totalPrice)
                .build();

        return orderRepository.save(newOrder);
    }
}