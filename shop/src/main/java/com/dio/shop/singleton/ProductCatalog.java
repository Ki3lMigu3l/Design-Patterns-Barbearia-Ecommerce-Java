package com.dio.shop.singleton;

import com.dio.shop.entity.model.Product;
import com.dio.shop.entity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCatalog {
    private static ProductCatalog instance;

    @Autowired
    private ProductRepository productRepository;

    private ProductCatalog () {
        // Inicialização do catálogo de produtos a partir do
        // banco de dados ou dados em memória
    }

    public static ProductCatalog getInstance() {
        if (instance == null) {
            instance = new ProductCatalog();
        }
        return instance;
    }

    public void addProduct (Product product) {
        productRepository.save(product);
    }

    public void removeProduct (Product product) {
        productRepository.delete(product);
    }

    public Product getProductById (Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
