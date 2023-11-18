package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    List<Product> findByIsEnabledTrue();

}
