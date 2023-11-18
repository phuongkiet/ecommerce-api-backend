package com.tutorial.ecommerceapi.service;

import com.tutorial.ecommerceapi.api.model.ProductInventoryBody;
import com.tutorial.ecommerceapi.model.Category;
import com.tutorial.ecommerceapi.model.Inventory;
import com.tutorial.ecommerceapi.model.Product;
import com.tutorial.ecommerceapi.model.dao.CategoryDAO;
import com.tutorial.ecommerceapi.model.dao.InventoryDAO;
import com.tutorial.ecommerceapi.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;
    private InventoryDAO inventoryDAO;
    private CategoryDAO categoryDAO;

    public ProductService(ProductDAO productDAO, InventoryDAO inventoryDAO, CategoryDAO categoryDAO) {
        this.productDAO = productDAO;
        this.inventoryDAO = inventoryDAO;
        this.categoryDAO = categoryDAO;
    }

    public List<Product> getAllProduct(){
        return productDAO.findAll();
    }

    public Product addProduct(ProductInventoryBody body) {
        if(body == null){
            throw new IllegalArgumentException("Request must not be null");
        }
        Product product = new Product();
        Inventory inventory = new Inventory();
        Category category = new Category();

        product.setName(body.getName());
        product.setShortDescription(body.getShortDescription());
        product.setLongDescription(body.getLongDescription());
        product.setPrice(body.getPrice());
        product.setEnabled(true);
        category = categoryDAO.findById(body.getCategoryId()).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        product.setCategory(category);
        
        Product savedProduct = productDAO.save(product);
        
        if (savedProduct == null) {
            throw new RuntimeException("Failed to save product");
        }
        
        inventory.setQuantity(body.getQuantity());
        inventory.setProduct(savedProduct);
        
        Inventory savedInventory = inventoryDAO.save(inventory);
        
        if (savedInventory == null) {
            throw new RuntimeException("Failed to save inventory");
        }
        
        return savedProduct;
    }

    public Product updateProduct(Long id, ProductInventoryBody body){
        if(body == null){
            throw new IllegalArgumentException("Request must not be null");
        }
        Product product = productDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setName(body.getName());
        product.setShortDescription(body.getShortDescription());
        product.setLongDescription(body.getLongDescription());
        product.setPrice(body.getPrice());
        Category category = categoryDAO.findById(body.getCategoryId()).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        product.setCategory(category);
        Product updatedProduct = productDAO.save(product);
        if(updatedProduct == null){
            throw new RuntimeException("Failed to update product");
        }
        Inventory inventory = inventoryDAO.findByProduct(product).orElseThrow(() -> new IllegalArgumentException("Inventory not found"));
        inventory.setQuantity(body.getQuantity());
        Inventory updatedInventory = inventoryDAO.save(inventory);
        if(updatedInventory == null){
            throw new RuntimeException("Failed to update inventory");
        }
        return updatedProduct;
    }

    public Product deleteProduct(Long id){
        Product product = productDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setEnabled(false);
        Product deletedProduct = productDAO.save(product);
        if(deletedProduct == null){
            throw new RuntimeException("Failed to delete product");
        }
        return deletedProduct;
    }


}
