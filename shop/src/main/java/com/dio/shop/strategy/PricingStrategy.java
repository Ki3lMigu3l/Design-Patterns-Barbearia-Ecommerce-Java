package com.dio.shop.strategy;

import com.dio.shop.entity.model.Product;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice (List<Product> productList);
}
