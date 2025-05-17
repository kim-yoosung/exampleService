package com.example.exampleservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

@RestController
public class ConnectController {

    @GetMapping("/connect")
    public String tryConnect() {
        String host = "google.com";
        int port = 80;
        String result;

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 5000);

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("GET / HTTP/1.1");
            writer.println("Host: " + host);
            writer.println("Connection: close");
            writer.println();

            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null && response.length() < 1000) {
                response.append(line).append("\n");
            }

            result = "Successfully connected and communicated with " + host + ":" + port + "\nResponse preview:\n" + response;
        } catch (IOException e) {
            result = "Failed to connect to " + host + ":" + port + " - Error: " + e.getMessage();
        }
        return result;
    }
}
