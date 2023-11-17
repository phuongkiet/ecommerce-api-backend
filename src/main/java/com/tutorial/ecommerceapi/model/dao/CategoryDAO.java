package com.tutorial.ecommerceapi.model.dao;

import com.tutorial.ecommerceapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryDAO extends JpaRepository<Category, Long> {

    @Override
    Optional<Category> findById(Long aLong);
}
