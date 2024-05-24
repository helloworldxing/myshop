package com.example.myshop.service;

import com.example.myshop.entity.User;
import com.example.myshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(User user) {
        return userRepository.findByName(user.getName()).orElse(null);
    }
}
