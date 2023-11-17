package com.tutorial.ecommerceapi.service;

import com.tutorial.ecommerceapi.api.model.CategoryBody;
import com.tutorial.ecommerceapi.model.Category;
import com.tutorial.ecommerceapi.model.dao.CategoryDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Category> getAllCategory(){
        return categoryDAO.findAll();
    }

    public Category addCategory(CategoryBody category){
        Category savedCategory = new Category();
        savedCategory.setCategoryName(category.getCategoryName());
        if(savedCategory == null){
            throw new IllegalArgumentException("Failed to save category");
        }
        return categoryDAO.save(savedCategory);
    }
}
