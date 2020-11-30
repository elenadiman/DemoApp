package com.example.demo;

import com.example.demo.config.PayloadConfig;
import com.example.demo.filter.PayloadFilter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PayloadFilterTest {

    @Test
    public void doFilterTest()throws IOException, ServletException{

        HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = Mockito.mock(HttpServletResponse.class);
        FilterChain mockFilterChain = Mockito.mock(FilterChain.class);
        PayloadConfig mockPayloadConfig = Mockito.mock(PayloadConfig.class);

        PayloadFilter payloadFilter = new PayloadFilter(mockPayloadConfig);

        payloadFilter.doFilter(mockRequest, mockResponse, mockFilterChain);

    }

}
