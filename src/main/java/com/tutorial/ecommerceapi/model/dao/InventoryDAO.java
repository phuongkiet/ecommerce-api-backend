package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDAO extends JpaRepository<Inventory, Long> {

}
