package com.example.demo.api;

import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    public static class CreateCardRequest{
        public String cardNumber;
        public String type;
        public Long balance;
        public Date validFrom;
        public Date validTo;
        public String status;
        public String visiblePan;
    }

    @PostMapping("/api/cards")
    public void createCard(@RequestBody CreateCardRequest request){
        cardService.createCard(request.cardNumber, request.type, request.balance, request.validFrom, request.validTo, request.status, request.visiblePan);
    }
    @GetMapping("/api/cards")
    public List<Card>findCards(){
        return cardService.findCards();
    }
}
