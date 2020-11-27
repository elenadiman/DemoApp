package com.example.demo.api;

import com.example.demo.config.PayloadConfig;
import com.example.demo.dto.CreateCardRequest;
import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/api/cards")
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @GetMapping("/api/cards")
    public List<Card> findCards() {
        return cardService.findCards();
    }

    @GetMapping("/api/cards/{id}")
    public Card findCard(@PathVariable Long id) {
        return cardService.findCard(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/card/{cardNo}")
    public Card findCardByCardNumber(@PathVariable String cardNo) {
        return cardService.findCardByCardNumber(cardNo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/api/cards/{id}")
    public Card updateCard(@PathVariable Long id, @RequestBody CreateCardRequest createCardRequest) {
        return cardService.updateCard(id, createCardRequest);
    }

    @DeleteMapping("/api/cards/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }
}
