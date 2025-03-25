//package com.example.exampleservice.filter;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.logging.Logger;
//
//public class HttpLoggingFilter implements Filter {
//    private static final Logger logger = Logger.getLogger(HttpLoggingFilter.class.getName());
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        logger.info("[MSA HttpLoggingFilter] 🚀 `HttpLoggingFilter` 초기화됨.");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
//            HttpServletRequest httpRequest = (HttpServletRequest) request;
//            HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//            logger.info("[MSA HttpLoggingFilter] 🌍 HTTP 요청 감지됨: " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());
//        }
//
//        chain.doFilter(request, response);
//
//        if (response instanceof HttpServletResponse) {
//            logger.info("[MSA HttpLoggingFilter] 🔄 HTTP 응답 상태 코드: " + ((HttpServletResponse) response).getStatus());
//        }
//    }
//
//    @Override
//    public void destroy() {
//        logger.info("[MSA HttpLoggingFilter] ❌ `HttpLoggingFilter`가 종료됨.");
//    }
//}
