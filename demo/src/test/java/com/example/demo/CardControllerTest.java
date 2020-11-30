package com.example.demo;

import com.example.demo.api.CardController;
import com.example.demo.dto.CreateCardRequest;
import com.example.demo.model.Card;
import com.example.demo.service.CardService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.Mockito.when;


import java.sql.Date;
@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
public class CardControllerTest {

    @Autowired
    private CardController cardController;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CardService cardService;


    @Test
    public void findCardByCardNoTest() throws Exception {
        Card card = new Card();
        when(cardService.findCardByCardNumber(anyString())).thenReturn(java.util.Optional.of(card));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/card/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findCardByIdTest() throws Exception {
        Card card = new Card();
        when(cardService.findCard(anyLong())).thenReturn(java.util.Optional.of(card));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cards/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCardTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cards/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findCardsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cards"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createCardTest() throws Exception {
        Card card = new Card();
        card.setType("1");
        card.setBalance(7000L);
        card.setValidFrom(Date.valueOf("2020-12-01"));
        card.setValidTo(Date.valueOf("2021-12-01"));
        card.setStatus("active");
        card.setVisiblePan("12345");
        card.setCardNumber("1234567890");

        when(cardService.createCard(any(Card.class))).thenReturn(card);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/cards/")
                .content(new ObjectMapper().writeValueAsString(card))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(7000L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.validFrom").value("2020-12-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.validTo").value("2021-12-01"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("active"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.visiblePan").value("12345"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cardNumber").value("1234567890"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateCardTest() throws Exception {
        Card card = new Card();
        card.setCardNumber("101010101");
        when(cardService.updateCard(anyLong(), any(CreateCardRequest.class))).thenReturn(card);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/cards/1")
                .content(new ObjectMapper().writeValueAsString(card))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cardNumber").value("101010101"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
