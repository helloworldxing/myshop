package com.example.myshop.service;


import com.example.myshop.entity.Products;
import com.example.myshop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public void addProduct(String name,Double price) {
        Products products = new Products();
        products.setName(name);
        products.setPrice(price);
        productsRepository.save(products);
    }


    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    public Products findProductById(Integer id) {
        return productsRepository.findById(id).orElse(null);
    }
}
