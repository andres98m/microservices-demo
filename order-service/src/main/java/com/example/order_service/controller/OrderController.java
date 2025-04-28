package com.example.order_service.controller;

import com.example.order_service.model.CreateOrderDTO;
import com.example.order_service.model.Order;
import com.example.order_service.model.Product;
import com.example.order_service.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order", description = "OrderController")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrderV2")
    @Operation(summary = "createOrder", description = "Create a new order correctly")
    public Order createOrderV2(@RequestBody CreateOrderDTO order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    @Operation(summary = "getAllOrders", description = "Get all orders")
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    @Operation(summary = "getOrderById", description = "Get order by ID")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("product/{productId}")
    @Operation(summary = "getProductById", description = "Get product by ID")
    public Product getProduct(@PathVariable String productId) {
        return orderService.getProductById(productId);
    }
}
