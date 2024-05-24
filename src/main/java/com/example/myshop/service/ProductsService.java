package com.example.myshop.service;

import com.example.myshop.entity.Products;
import com.example.myshop.repository.ProductsRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public Products addProduct(Products product) {
        return productsRepository.save(product);
    }

    public void removeProduct(Long id) {
        productsRepository.deleteById(id);
    }

    public Products getProduct(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    public Products updateProduct(Products product) {
        return productsRepository.save(product);
    }
}
