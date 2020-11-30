package com.example.demo.filter;

import com.example.demo.config.PayloadConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component

public class PayloadFilter implements Filter {

    private final PayloadConfig payloadConfig;

    @Autowired
    public PayloadFilter(PayloadConfig payloadConfig){
        this.payloadConfig=payloadConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        int i = 0;
        if(request.getContentLengthLong() > payloadConfig.getMaximumRequestSize()){
            response.sendError(i, "Payload size is too large");
        }

        filterChain.doFilter(servletRequest, servletResponse);


    }

}
