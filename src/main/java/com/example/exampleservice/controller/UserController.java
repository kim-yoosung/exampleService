package com.example.exampleservice.controller;

import com.example.exampleservice.entity.User;
import com.example.exampleservice.exception.BizException;
import com.example.exampleservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final RestTemplate restTemplate;

    public UserController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
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

    @GetMapping("/id")
    public Optional<User> getUsers(@RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            return userService.getUsersByID(id);
        } else {
            System.out.println("wow");
            return null;
        }
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PutMapping("/serB")
    public User updateUserByServiceB(@RequestBody User user) {
        Long userId = user.getId();

        // MSA-B에 GET 요청 → id 기반 이름 조회
        String msaBUrl = "http://localhost:8082/user-info?id=" + userId;
        ResponseEntity<String> response = restTemplate.getForEntity(msaBUrl, String.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            System.out.println("nameee!!!" + response.getBody());
            user.setName(response.getBody()); // MSA-B에서 받은 이름으로 변경
        } else {
            user.setName("기본 이름");
        }

        return userService.updateUser(user);
    }

    // 사용자 삭제 (DELETE /users/{id})
    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "id") Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/test/biz-exception")
    public ResponseEntity<String> testBizException() {
        throw new BizException("비즈니스 예외가 발생했습니다.");
    }

    @GetMapping("/test/general-exception")
    public ResponseEntity<String> testGeneralException() {
        throw new RuntimeException("일반 예외가 발생했습니다.");
    }
}
