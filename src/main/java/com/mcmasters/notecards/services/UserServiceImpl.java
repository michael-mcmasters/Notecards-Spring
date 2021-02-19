package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.mocks.User;
import com.mcmasters.notecards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getSampleUser() {
        User user = new User("ano", "money99", "brokebois@yahoo.net", new HashSet(), "badge1");
        userRepository.save(user);
        return user;
    }

    @Override
    public Set<User> getSetOfUsers() {
        User user = new User("ano", "money99", "brokebois@yahoo.net", new HashSet(), "badge1");
        User user1 = new User("wer", "few", "werfe2@yahoo.net", new HashSet(), "badge1342");
        userRepository.save(user);
        userRepository.save(user1);
        Set<User> set = new HashSet<>();
        set.add(user);
        set.add(user1);
        return set;
    }

    @Override
    public Deck getUsersDecks() {
        return new Deck();
    }

    @Override
    public List<Card> getUsersCards() {
//        Deck deck = new Deck();
//
//        CardService cardService = new CardServiceImpl();
//        Card card1 = new Card("What are the 4 principles of Object Oriented Programming?", "A PIE. Abstraction, Polymorphism, Inheritance, Encapsulation", deck);
//        Card card2 = new Card("Explain abstraction", "Abstraction means using simple things to represent complexity. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets us avoid repeating the same work multiple times. It handles complexity by hiding unnecessary details from the user", deck);
//        Card card3 = new Card("Explain polymorphism", "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)", deck);
//        cardService.saveCard(card1);
//        cardService.saveCard(card2);
//        cardService.saveCard(card3);
//
//        deck.addCards(card1);
//        deck.addCards(card2);
//        deck.addCards(card3);
//
//        User user = getSampleUser();
//        user.addDeck(deck);
//
//        userRepository.save(user);
//        return deck.getCards();


        Deck deck = new Deck();
        deck.addCards(new Card(deck, "What are the 4 principles of Object Oriented Programming?", "A PIE. Abstraction, Polymorphism, Inheritance, Encapsulation"));
        deck.addCards(new Card(deck, "Explain abstraction", "Abstraction means using simple things to represent complexity. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets us avoid repeating the same work multiple times. It handles complexity by hiding unnecessary details from the user"));
        deck.addCards(new Card(deck, "Explain polymorphism", "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)"));
        User user = getSampleUser();
        user.addDeck(deck);

        userRepository.save(user);
        return deck.getCards();
    }

    @Override
    public Set<Card> getUsersCards(User user) {
        return null;
    }
}
