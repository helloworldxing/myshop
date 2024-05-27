package com.example.myshop.controller;

import com.example.myshop.entity.Products;
import com.example.myshop.entity.Result;
import com.example.myshop.repository.ProductsRepository;
import com.example.myshop.repository.UserRepository;
import com.example.myshop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/list")
    public Result<List<Products>> list() {
        List<Products> products = productsService.findAllProducts();
        return Result.success(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<Products>> getProduct(@PathVariable Integer id) {
        Products product = productsService.findProductById(id);
        if (product != null) {
            return ResponseEntity.ok(Result.success(product));
        } else {
            return ResponseEntity.ok(Result.error("商品不存在"));
        }
    }

    public Result addProduct( String name,Double price) {
        Optional<Products> product = productsRepository.findAllByName(name);
        if (product != null) {
            return Result.error("商品已存在！");
        }
        else
        productsService.addProduct(name, price);
        return Result.success("商品添加成功！");
    }
}