package com.example.demo.service;

import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;


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

    public Optional<Card> findCard(Long id) {
        return cardRepository.findById(id);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    public Card updateCard(Long id, String cardNo, String type, Long balance, Date validFrom, Date validTo, String status, String visiblePan) {
       Card card = cardRepository.findById(id).get();
                card.setCardNumber(cardNo);
                card.setType(type);
                card.setBalance(balance);
                card.setValidFrom(validFrom);
                card.setValidTo(validTo);
                card.setStatus(status);
                card.setVisiblePan(visiblePan);
                return cardRepository.save(card);
    }


    public Optional<Card> findCardByCardNumber(String cardNo) {
        return cardRepository.findAll().stream()
                .filter(card -> card.getCardNumber().equals(cardNo)).findAny();
    }
}
