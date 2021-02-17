package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.mocks.User;
import com.mcmasters.notecards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getSampleUser() {
        User user = new User("ano", "money99", "brokebois@yahoo.net", new HashSet(), "badge1");
        userRepository.save(user);
        return user;
    }

    @Override
    public Deck getUsersDecks() {
        return new Deck();
    }

    @Override
    public Card getUsersCards() {
//        Deck deck = new Deck();
//        deck.addCards(new Card("first card front!", "back of card!", deck));
//        deck.addCards(new Card("second card front!", "back of card!", deck));
//        deck.addCards(new Card("third card front!", "back of card!", deck));
//
//        User user = getSampleUser();
//        user.addDeck(deck);
//
//        userRepository.save(user);
//        return deck.getCards().iterator().next();

        return new Card("first card front!", "back of card!", new Deck());
    }
}
