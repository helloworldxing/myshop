package com.example.myshop.controller;

import com.example.myshop.entity.Result;
import com.example.myshop.entity.Users;
import com.example.myshop.repository.UserRepository;
import com.example.myshop.service.UserService;
import com.example.myshop.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register")
    public Result register(String name, String password) {
    Users existingUser = userRepository.findByUserName(name);
    if (existingUser == null) {
        Users newUser = new Users();
        newUser.setName(name);
        newUser.setPassword(Md5Util.getMD5String(password)); // Assuming you want to store password as MD5 hash
        userService.registerUser(newUser);
        return Result.success();
    } else {
        return Result.error("用户名已存在");
    }
}

    @PostMapping("/login")
    public Result login(String name,String password) {
        User user = (User) userRepository.findByUserName(name);
        if (user == null) {
            return Result.error("用户错误");
        }
        if(Md5Util.getMD5String(password).equals(user.getPassword())){
            return Result.success();
        }
        return Result.error("密码错误");
    }
}
