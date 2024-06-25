package com.dio.shop.facade;

import com.dio.shop.entity.model.Product;
import com.dio.shop.singleton.ProductCatalog;
import com.dio.shop.strategy.PricingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacade {
    @Autowired
    private ProductCatalog productCatalog;

    @Autowired
    private PricingStrategy pricingStrategy;

    public double placeOrder (List<Product> productList) {
        double totalPrice = pricingStrategy.calculatePrice(productList);
        return totalPrice;
    }
}
