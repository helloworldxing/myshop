package com.example.myshop.service;


import com.example.myshop.entity.Users;
import com.example.myshop.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 注册用户
    public void registerUser(Users user) {
        userRepository.save(user);
    }

    // 登录用户
    public Users loginUser(String username, String password) {
        Users user = userRepository.findByUserName(username);

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        // 判断密码是否正确
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        return user;
    }
}