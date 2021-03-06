package com.example.demo.filter;

import com.example.demo.config.PayloadConfig;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PayloadFilter implements Filter {

    private final PayloadConfig payloadConfig;

    public PayloadFilter(PayloadConfig payloadConfig){
        this.payloadConfig=payloadConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getContentLengthLong() > payloadConfig.getMaximumRequestSize()){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write(getErrorMessageTemplate()
                    .formatted("Payload size is too large"));
            return;
        }

        filterChain.doFilter(request, response);


    }

    private String getErrorMessageTemplate() {
        return """
            {
              "error_message": "%s" 
            }
            """;
    }


}
