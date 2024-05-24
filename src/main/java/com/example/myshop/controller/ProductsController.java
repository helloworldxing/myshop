package com.example.myshop.controller;

import com.example.myshop.entity.Products;
import com.example.myshop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @PostMapping
    public ResponseEntity<Products> addProduct(@RequestBody Products product) {
        return ResponseEntity.ok(productsService.addProduct(product));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productsService.getProduct(id));
    }
    @PutMapping
    public ResponseEntity<Products> updateProduct(@RequestBody Products product) {
        return ResponseEntity.ok(productsService.updateProduct(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id) {
        productsService.removeProduct(id);
        return ResponseEntity.ok().build();
    }


}
