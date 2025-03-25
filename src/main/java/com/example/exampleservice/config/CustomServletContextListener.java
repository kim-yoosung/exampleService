//package com.example.exampleservice.config;
//
//import com.example.exampleservice.filter.HttpLoggingFilter;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebListener;
//
//import java.util.EnumSet;
//
//@WebListener  // ✅ Spring Context 없이 ServletContext에서 직접 실행
//public class CustomServletContextListener implements ServletContextListener {
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        ServletContext servletContext = sce.getServletContext();
//
//        // ✅ 필터 등록
//        FilterRegistration.Dynamic filter = servletContext.addFilter("HttpLoggingFilter", new HttpLoggingFilter());
//
//        // ✅ HTTP 요청을 처리하는 필터 체인에 포함되도록 설정
//        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
//
//        System.out.println("[MSA] ✅ `HttpLoggingFilter`가 `ServletContext`에 직접 등록됨.");
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("[MSA HttpLoggingFilter] ❌ `ServletContext`가 종료됨.");
//    }
//}
