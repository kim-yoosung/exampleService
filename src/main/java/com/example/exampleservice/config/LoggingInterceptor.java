package com.example.exampleservice.config;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request,
            byte[] body,
            ClientHttpRequestExecution execution) throws IOException {

        // 요청 정보 로깅
        System.out.println("➡️ [MSA-A 요청]");
        System.out.println("URI: " + request.getURI());
        System.out.println("Method: " + request.getMethod());
        System.out.println("Headers: " + request.getHeaders());
        System.out.println("Body: " + new String(body, StandardCharsets.UTF_8));
        System.out.println("[DEBUG] request class: " + request.getClass());
        ClientHttpResponse response = execution.execute(request, body);

        // 응답 정보 로깅
        System.out.println("⬅️ [MSA-A 응답]");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Headers: " + response.getHeaders());

        return response;
    }
}
