package com.tutorial.ecommerceapi.api.controller.product;

import com.tutorial.ecommerceapi.api.model.ProductInventoryBody;
import com.tutorial.ecommerceapi.model.Inventory;
import com.tutorial.ecommerceapi.model.Product;
import com.tutorial.ecommerceapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Get a list of product that is enabled
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductInventoryBody body){
        Product savedProduct = productService.addProduct(body);
        return ResponseEntity.ok(savedProduct);
    }

    //Update product
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    @PostMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductInventoryBody body, @RequestParam Long productId){
        Product updatedProduct = productService.updateProduct(productId, body);
        return ResponseEntity.ok(updatedProduct);
    }

    //Delete Product by change the status of the Enabled
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    @PostMapping("/deleteProduct")
    public ResponseEntity<Product> deleteProduct(@RequestParam Long productId){
        Product deleteProduct = productService.deleteProduct(productId);
        return ResponseEntity.ok(deleteProduct);
    }
}
