package com.mcmasters.notecards.controllers;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.mocks.Homepage;
import com.mcmasters.notecards.services.CardService;
import com.mcmasters.notecards.services.DeckService;
import com.mcmasters.notecards.services.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class HomepageController {

    @Autowired
    private HomepageService homepageService;

    @Autowired
    private DeckService deckService;

    @Autowired
    private CardService cardService;

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

//    @GetMapping("/")
//    private ResponseEntity<Iterable<Homepage>> getCards() {
//
//        Homepage homepage;
//        if (!homepageService.existsById(0L)) {
//            System.out.println("Does not exist");
//            homepage = new Homepage();
//            homepage.setId(0L);
//            homepage.setTestName("Waffle House");
//            homepageService.save(homepage);
//        } else {
//            System.out.println("Does exist");
//            homepage = homepageService.findById(0L);
//        }
//
//        System.out.println("All homepages: " + homepageService.getAllHomepages());
//        return ResponseEntity.ok().body(homepageService.getAllHomepages());
//    }

    @GetMapping("/")
    private ResponseEntity<Iterable<Card>> getCards() {

        Homepage homepage;
        if (!homepageService.existsById(0L)) {
            System.out.println("Does not exist");
            homepage = new Homepage();
            homepage.setId(0L);
            homepage.setTestName("Waffle House");

            Deck deck = getDefaultDeck();
            homepage.addDecks(deck);
            homepageService.save(homepage);
        } else {
            System.out.println("Does exist");
            homepage = homepageService.findById(0L);
        }

//        System.out.println("All homepages: " + homepageService.getAllHomepages());
//        return ResponseEntity.ok().body(homepageService.getAllHomepages());
        Deck firstDeck = homepage.getDecks().iterator().next();         // Get users first deck
        return ResponseEntity.ok().body(firstDeck.getCards());          // Return all cards in deck
    }

    private Deck getDefaultDeck() {
        Deck deck = new Deck();
        deck.addCards(new Card(deck, "first card!", "A PIE. Abstraction, Polymorphism, Inheritance, Encapsulation", "red"));
        deck.addCards(new Card(deck, "Second card!", "Abstraction means using simple things to represent complexity. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets us avoid repeating the same work multiple times. It handles complexity by hiding unnecessary details from the user", "red"));
        deck.addCards(new Card(deck, "Third Card!", "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)", "red"));
        deck.addCards(new Card(deck, "Explain polymorphism", "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)"));

deck.addCards(new Card(deck, "Explain inheritance", "This is a special feature of Object Oriented Programming in Java. It lets programmers create new classes that share some of the attributes of existing classes. This lets us build on previous work without reinventing the wheel. * The ability for a sub class to access the super class's members implicitly through the keyword 'extends'; Members include methods as well as variables."));
deck.addCards(new Card(deck, "Explain encapsulation","This is the practice of keeping fields within a class private, then providing access to them via public methods. It’s a protective barrier that keeps the data and code safe within the class itself. This way, we can re-use objects like code components or variables without allowing open access to the data system-wide."));
deck.addCards(new Card(deck,"What are the 4 access modifiers and their access specifiers","Public: Class, Package, Subclass, Global, Variable Protected: Class, Package, Subclass Default: Class, Package Private: Class, Variable"));
deck.addCards(new Card(deck,"What are the 5 SOLID principles?","Single Responsibility, Open/Close Principle, Liskov's Substitution Principle, Interface Segregation Principle, Dependency Inversion"));
deck.addCards(new Card(deck, "Explain 'Single Responsibility'", "a class should have only a single responsibility (i.e. changes to only one part of the software's specification should be able to affect the specification of the class)."));
deck.addCards(new Card(deck, "Explain 'Open/Close Principle'", "'open for extension, but closed for modification.' classes' properties can be inherited and used by subclasses etc, but not altered directly"));
deck.addCards(new Card(deck,"Explain 'Liskov's Substitution Principle", "'objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.'"));
deck.addCards(new Card(deck,"Explain 'Interface Segregation Principle'","'many client-specific interfaces are better than one general-purpose interface.' in other words, when you implement an interface, do you want your class flooded with empty methods you'll never use, or just the few that offer the functionality you are looking for?"));
deck.addCards(new Card(deck, "Explain 'Dependency Inversion'", "one should 'depend upon abstractions, [not] concretions.' In other words--don't extend ArrayList class to get those functions; implement List interface instead."));
deck.addCards(new Card(deck, "What is the difference between overloading and overriding?", "Overloading occurs when two or more methods in one class have the same method name but different parameters. Overriding means having two methods with the same method name and parameters (i.e., method signature). One of the methods is in the parent class and the other is in the child class. Overriding changes the BEHAVIOR of the method."));
deck.addCards(new Card(deck, "What is the difference between an abstract class and an interface?", "An abstract class can contain non abstract methods and default methods, an interface can only contain method signatures. A class can only extend one abstract class, but it can implement multiple interfaces. An abstract class can have any access modifiers on it's methods and fields, an interface can only be public. Interface fields are public static final. Both can let you use classes of the same supertype."));
deck.addCards(new Card(deck, "For Interface and Abstract Class, why would you use one over the other?", "You can implement multiple interfaces but you can only extend one abstract class. Also, you can flesh out methods more fully in an abstract class; Interfaces are for empty methods."));
deck.addCards(new Card(deck, "What is the difference between 'Collection' and 'Collections'", "Collections is an utility class present in java.util. package to define several utility method (like sorting,searching ) for collection object. Collections is a class which has some static methods and that method returns the collection. Collection is an interface; root interface in collection hierarchy"));



        return deck;
    }
}
