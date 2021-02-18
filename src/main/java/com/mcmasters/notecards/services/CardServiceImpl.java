package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void createCard(Card card) {
        cardRepository.save(card);
    }
}
