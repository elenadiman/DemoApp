package com.example.demo;

import com.example.demo.api.TestController;
import com.example.demo.config.PayloadConfig;
import com.example.demo.filter.PayloadFilter;
import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.MockMvc;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
@TestPropertySource(properties = "configuration.maximumRequestSize=200")
public class PayloadFilterTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    FilterChain filterChain;
    @Mock
    PayloadConfig config;
    @MockBean
    PayloadFilter filter;
    @MockBean
    CardService service;


    @Test
    public void doFilterTest() throws Exception {
        Card card = new Card();
            given(service.createCard(any(Card.class))).willReturn(card);
            filter.doFilter(request, response, filterChain);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/test/")
                .content(new ObjectMapper().writeValueAsString(card))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
        }

}
