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

//    {
//        "backgroundColor": "#31587A",
//            "frontText": "What are the 4 principles of Object Oriented Programming?",
//            "backText": "A PIE. Abstraction, Polymorphism, Inheritance, Encapsulation",
//            "timesAccepted": "0"
//    },
//    {
//        "backgroundColor": "#E8525B",
//            "frontText": "Explain abstraction",
//            "backText": "Abstraction means using simple things to represent complexity. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets us avoid repeating the same work multiple times. It handles complexity by hiding unnecessary details from the user",
//            "timesAccepted": "0"
//    },
//    {
//        "backgroundColor": "#E8525B",
//            "frontText": "Explain polymorphism",
//            "backText": "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)",
//            "timesAccepted": "0"
//    },

    @Override
    public Set<Card> getUsersCards() {
        Deck deck = new Deck();

        deck.addCards(new Card("What are the 4 principles of Object Oriented Programming?", "A PIE. Abstraction, Polymorphism, Inheritance, Encapsulation", deck));
        deck.addCards(new Card("Explain abstraction", "Abstraction means using simple things to represent complexity. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets us avoid repeating the same work multiple times. It handles complexity by hiding unnecessary details from the user", deck));
        deck.addCards(new Card("Explain polymorphism", "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)", deck));

        User user = getSampleUser();
        user.addDeck(deck);

        userRepository.save(user);
        return deck.getCards();
    }
}
