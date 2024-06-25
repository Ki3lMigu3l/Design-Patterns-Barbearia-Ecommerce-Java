package com.dio.shop.entity.repository;

import com.dio.shop.entity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
