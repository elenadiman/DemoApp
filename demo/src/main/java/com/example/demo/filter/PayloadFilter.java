package com.example.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PayloadFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        int i = 0;
        int maxPayloadSize = 4000;
        if (response.getBufferSize() > maxPayloadSize) {
            response.sendError(i, "Payload size is too large");
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

}
