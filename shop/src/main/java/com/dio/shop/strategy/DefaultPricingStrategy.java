package com.dio.shop.strategy;

import com.dio.shop.entity.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Product> productList) {
        return productList
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
