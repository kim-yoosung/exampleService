package com.example.exampleservice.controller;

import com.example.exampleservice.entity.User;
import com.example.exampleservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 등록 (POST /users)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // 전체 사용자 조회 (GET /users)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
