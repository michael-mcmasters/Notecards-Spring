package com.mcmasters.notecards.controllers;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.mocks.User;
import com.mcmasters.notecards.services.CardService;
import com.mcmasters.notecards.services.DeckService;
import com.mcmasters.notecards.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DeckService deckService;
    @Autowired
    private CardService cardService;

    @GetMapping("/getsampleuser")
    public ResponseEntity<User> getSampleUser(String username, String password) {
        return ResponseEntity.ok().body(userService.getSampleUser());
    }

    @GetMapping("/getsetofusers")
    public ResponseEntity<Set<User>> getSetOfUsers(String username, String password) {
        return ResponseEntity.ok().body(userService.getSetOfUsers());
    }

//    @GetMapping("user/{id}/cards")
//    public ResponseEntity<User> getUserCard() {
//
//    }

    @GetMapping("/decks")
    public ResponseEntity<Deck> getUserDecks() {
        return ResponseEntity.ok().body(userService.getUsersDecks());
    }

    @GetMapping("/cards")
    public ResponseEntity<List<Card>> getUserCard() {
        User user = new User();
        Deck deck = new Deck();
        deck.addCards(new Card(deck, "What are the 4 principles of Object Oriented Programming?", "A PIE. Abstraction, Polymorphism, Inheritance, Encapsulation"));
        deck.addCards(new Card(deck, "Explain abstraction", "Abstraction means using simple things to represent complexity. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets us avoid repeating the same work multiple times. It handles complexity by hiding unnecessary details from the user"));
        deck.addCards(new Card(deck, "Explain polymorphism", "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)"));
        user.addDeck(deck);

        // Saving user will save all OnetoMany pojos in their servers. However it seems to save them in random orders.
        // Saving them manually using the DeckServer and CardServer may solve this.
        userService.createUser(user);

        Deck firstDeck = user.getDecks().iterator().next();         // Get users first deck
        return ResponseEntity.ok().body(firstDeck.getCards());      // Return all cards in deck

    }
}
