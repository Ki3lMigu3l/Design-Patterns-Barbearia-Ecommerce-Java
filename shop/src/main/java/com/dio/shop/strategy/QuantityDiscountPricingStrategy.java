package com.dio.shop.strategy;

import com.dio.shop.entity.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuantityDiscountPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Product> productList) {
        return 0.0;
    }
}
