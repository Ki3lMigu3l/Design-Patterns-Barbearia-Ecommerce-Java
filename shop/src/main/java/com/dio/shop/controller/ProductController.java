package com.dio.shop.controller;

import com.dio.shop.entity.model.Product;
import com.dio.shop.singleton.ProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductCatalog productCatalog;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productCatalog.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById (@PathVariable Long id) {
        return productCatalog.getProductById(id);
    }
}
