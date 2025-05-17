package com.example.exampleservice.controller;

import com.example.exampleservice.dto.SocketRequest;
import com.example.exampleservice.service.SocketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SocketController {

    private final SocketService socketService;

    public SocketController(SocketService socketService) {
        this.socketService = socketService;
    }

    @PostMapping
    public ResponseEntity<String> send(@RequestBody SocketRequest request) {
        try {
            String response = socketService.sendAndReceive(request.getReqMsg());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("ERROR: " + e.getMessage());
        }
    }
}
