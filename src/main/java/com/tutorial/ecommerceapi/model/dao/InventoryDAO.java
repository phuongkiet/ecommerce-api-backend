package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.Inventory;
import com.tutorial.ecommerceapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryDAO extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByProduct(Product product);

}
