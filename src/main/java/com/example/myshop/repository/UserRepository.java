package com.example.myshop.repository;

import com.example.myshop.entity.Products;
import com.example.myshop.entity.Users;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {

    @Query("SELECT p FROM Users p WHERE p.name = ?#{[0]}")
    Users findByUserName(String name);
}
