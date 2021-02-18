package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Override
    public void createDeck(Deck deck) {
        deckRepository.save(deck);
    }
}
