package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.mocks.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    public void createUser(User user);

    public User getSampleUser();

    public Set<User> getSetOfUsers();

    public Deck getUsersDecks();

    public Set<Card> getUsersCards();

    public Set<Card> getUsersCards(User user);
}
