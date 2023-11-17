package com.tutorial.ecommerceapi.api.controller.category;

import com.tutorial.ecommerceapi.api.model.CategoryBody;
import com.tutorial.ecommerceapi.model.Category;
import com.tutorial.ecommerceapi.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody CategoryBody category){
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(savedCategory);
    }
}
