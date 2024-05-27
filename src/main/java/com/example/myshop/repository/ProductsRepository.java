package com.example.myshop.repository;

import com.example.myshop.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

    @Query("SELECT p FROM Products p WHERE p.name = ?#{[0]}")
    Optional<Products> findAllByName(String name);

}
