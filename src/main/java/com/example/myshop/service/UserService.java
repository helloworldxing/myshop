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
        User storedUser = userRepository.findByName(user.getName()).orElse(null);
        if (storedUser != null && storedUser.getPassword().equals(user.getPassword())) {
            // 密码匹配
            return storedUser;
        } else {
            // 用户名不存在或密码不匹配
            return null;
        }
    }
}
