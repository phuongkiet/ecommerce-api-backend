package com.tutorial.ecommerceapi.service;

import com.tutorial.ecommerceapi.api.model.ProductInventoryBody;
import com.tutorial.ecommerceapi.model.Inventory;
import com.tutorial.ecommerceapi.model.Product;
import com.tutorial.ecommerceapi.model.dao.InventoryDAO;
import com.tutorial.ecommerceapi.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;
    private InventoryDAO inventoryDAO;

    public ProductService(ProductDAO productDAO, InventoryDAO inventoryDAO) {
        this.productDAO = productDAO;
        this.inventoryDAO = inventoryDAO;
    }

    public List<Product> getProducts(){
        return productDAO.findAll();
    }

    public Product addProduct(ProductInventoryBody body) {
        if(body == null){
            throw new IllegalArgumentException("Request must not be null");
        }
        Product product = new Product();
        Inventory inventory = new Inventory();

        product.setName(body.getName());
        product.setShortDescription(body.getShortDescription());
        product.setLongDescription(body.getLongDescription());
        product.setPrice(body.getPrice());
        product.setEnabled(true);
        
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


}
