package com.example.exampleservice.service;

import com.example.exampleservice.entity.SampleEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class SampleService {
    private final Map<String, SampleEntity> database = new HashMap<>();
    // 데이터 저장
    public SampleEntity save(String name) {
        String id = UUID.randomUUID().toString();  // 랜덤 ID 생성
        SampleEntity entity = new SampleEntity(id, name);
        database.put(id, entity);
        return entity;
    }

    // 데이터 조회
    public SampleEntity find(String id) {
        return database.get(id);
    }
}
