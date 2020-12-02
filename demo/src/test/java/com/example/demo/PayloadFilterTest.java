package com.example.demo;

import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
@TestPropertySource(properties = "configuration.maximumRequestSize=100")
public class PayloadFilterTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CardService service;


    @Test
    public void doFilterTest() throws Exception {
        Card card = new Card();
            given(service.createCard(any(Card.class))).willReturn(card);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/test/")
                .content(new ObjectMapper().writeValueAsString(card))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error_message").value("Payload size is too large"));

        }

}
