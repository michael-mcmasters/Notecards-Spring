package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.mocks.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User getSampleUser();
    public Deck getUsersDecks();
    public Card getUsersCards();
}
