package com.example.product_service.controller;

import com.example.product_service.model.CreateProductDTO;
import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product", description = "ProductController")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Operation(summary = "getAllProducts", description = "Get all products")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    @Operation(summary = "getProductById", description = "Get product by ID")
    public Product getById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    @Operation(summary = "createProduct", description = "Create a new product")
    public Product create(@RequestBody CreateProductDTO product) {
        return productService.createProduct(product);
    }
}
