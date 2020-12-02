package com.example.demo;

import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final CardService cardService;

    @Autowired
    public TestController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/api/test")
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }
}
