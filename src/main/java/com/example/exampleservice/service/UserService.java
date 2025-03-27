package com.example.exampleservice.service;

import com.example.exampleservice.entity.User;
import com.example.exampleservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 생성
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    // 전체 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUsersByID(Long id) {
        return userRepository.findById(id);
    }
}
