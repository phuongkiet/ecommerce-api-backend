package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Long> {
}
