package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Deck;
import org.springframework.stereotype.Service;

@Service
public interface DeckService {

    public void createDeck(Deck deck);
}
