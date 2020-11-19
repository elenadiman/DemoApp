package com.example.demo.service;

import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


@org.springframework.stereotype.Service
public class CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void createCard(String cardNumber, String type, Long balance, Date validFrom, Date validTo, String status, String visiblePan) {
        Card card = new Card(cardNumber, type, balance, validFrom, validTo, status, visiblePan);
        cardRepository.save(card);
    }

    public List<Card> findCards() {
        return cardRepository.findAll();
    }

}
