package com.example.demo.service;

import com.example.demo.dto.CreateCardRequest;
import com.example.demo.mapper.CardMapper;
import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card createCard(Card card) {
        card = new Card(card.getCardNumber(), card.getType(), card.getBalance(), card.getValidFrom(), card.getValidTo(), card.getStatus(), card.getVisiblePan());
        return cardRepository.save(card);
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


    public Card updateCard(Long id, CreateCardRequest createCardRequest) {
        Card card = CardMapper.instance.card(id, createCardRequest);
        return cardRepository.save(card);
    }

    public Optional<Card> findCardByCardNumber(String cardNo) {
        return cardRepository.findByCardNo(cardNo);

    }

}
