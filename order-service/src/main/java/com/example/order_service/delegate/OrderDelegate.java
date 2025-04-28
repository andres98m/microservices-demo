package com.example.order_service.delegate;

import com.example.order_service.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderDelegate {
    private final RestTemplate restTemplate;

    public OrderDelegate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProduct(String id) {
        String url = "http://product-service:8080/api/products/" + id;
        return restTemplate.getForObject(url, Product.class);
    }
}
