package com.example.exampleservice.controller;

import com.example.exampleservice.entity.SampleEntity;
import com.example.exampleservice.service.SampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1")
public class SampleController {

    private final SampleService service;

    // Lombok 없이 직접 생성자 추가
    public SampleController(SampleService service) {
        this.service = service;
    }

    @PostMapping("/sample")
    public ResponseEntity<SampleEntity> save(@RequestParam String name) {
        return new ResponseEntity<>(service.save(name), HttpStatus.CREATED);
    }

    @GetMapping("/sample/{id}")
    public ResponseEntity<SampleEntity> get(@PathVariable String id) {
        return ResponseEntity.ok(service.find(id));
    }
}
