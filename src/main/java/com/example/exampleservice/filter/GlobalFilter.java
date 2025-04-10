package com.example.exampleservice.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class GlobalFilter implements Filter {
    private static final Logger logger = Logger.getLogger(GlobalFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("[MSA] 필터 초기화됨: " + this.getClass().getName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("[MSA] 현재 실행 중인 필터: " + this.getClass().getName());

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        logger.info("[MSA] 요청 URI: " + httpRequest.getRequestURI());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("[MSA] 필터 제거됨: " + this.getClass().getName());
    }
}
