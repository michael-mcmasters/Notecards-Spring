package com.mcmasters.notecards.controllers;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.mocks.Homepage;
import com.mcmasters.notecards.services.DeckService;
import com.mcmasters.notecards.services.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class HomepageController {

    @Autowired
    private HomepageService homepageService;

    @Autowired
    private DeckService deckService;

//    @Autowired
//    public HomepageController(Homepage homepage, DeckService deckService) {
//        this.homepage = homepage;
//        this.deckService = deckService;
//    }

//    @GetMapping("/")
//    private ResponseEntity<Set<Card>> getCards() {
//
//        System.out.println("All homepages: " + homepageService.getAllHomepages());
//
//        Homepage homepage = homepageService.findById(0L);
//        if (homepage == null) {
//            homepage = new Homepage();
//            homepage.setId(0L);
//            homepageService.save(homepage);
//        }
//        System.out.println("id is " + homepage.getId());
//
//        if (homepage.getDecks().size() == 0) {
//            System.out.println(homepage.getDecks().size());
//            Deck deck = new Deck();
//            deck.addCards(new Card("first card!", "A PIE. Abstraction, Polymorphism, Inheritance, Encapsulation", deck));
//            deck.addCards(new Card("Explain abstraction", "Abstraction means using simple things to represent complexity. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets us avoid repeating the same work multiple times. It handles complexity by hiding unnecessary details from the user", deck));
//            deck.addCards(new Card("Explain polymorphism", "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)", deck));
//            homepage.addDecks(deck);
//
//            deckService.createDeck(deck);
//            homepageService.save(homepage);
//        }
//
//        Deck firstDeck = homepage.getDecks().iterator().next();         // Get users first deck
//        return ResponseEntity.ok().body(firstDeck.getCards());          // Return all cards in deck
//    }

    @GetMapping("/")
    private ResponseEntity<Iterable<Homepage>> getCards() {

        Homepage homepage;
        if (!homepageService.existsById(0L)) {
            System.out.println("Does not exist");
            homepage = new Homepage();
            homepage.setId(0L);
            homepage.setTestName("Waffle House");
            homepageService.save(homepage);
        } else {
            System.out.println("Does exist");
            homepage = homepageService.findById(0L);
        }

        System.out.println("All homepages: " + homepageService.getAllHomepages());
        return ResponseEntity.ok().body(homepageService.getAllHomepages());
    }
}
