package com.example.exampleservice.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Service
public class SocketService {

    // ✅ 이 값을 원하는 IP/PORT로 설정하세요
    private final String targetIp = "10.0.0.1";
    private final int targetPort = 5000;

    public String sendAndReceive(String reqMsg) throws Exception {
        try (Socket socket = new Socket(targetIp, targetPort)) {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            os.write(reqMsg.getBytes());
            os.flush();

            byte[] buffer = new byte[1024];
            int read = is.read(buffer);

            return new String(buffer, 0, read);
        }
    }
}
