package com.example.exampleservice.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SampleEntity {
    private String id;
    private String name;

    public SampleEntity() {
    }

    // 필드 생성자
    public SampleEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
