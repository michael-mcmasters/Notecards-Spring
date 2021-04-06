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

@RestController
public class HomepageController {

    @Autowired
    private HomepageService homepageService;

    @Autowired
    private DeckService deckService;

    @Autowired
    private CardService cardService;

    @GetMapping("/")
    private String getHome() {
        return "<div style='width: fit-content; margin-left: auto; margin-right: auto;'>" +
                "<p>Welcome to my API. It is still a work in progress. Here are some URIs to look at in the mean time.</p>" +
                "<p>/core-java-deck, /spanish-deck, /state-capitals-deck</p>" +
                "</div>";
    }

    @GetMapping("/core-java-deck")
    private ResponseEntity<Iterable<Card>> getCoreJavaDeck() {
        Homepage homepage = getHomePage();
        return ResponseEntity.ok().body(homepage.getDecks().get(0).getCards());
    }

    @GetMapping("/spanish-deck")
    private ResponseEntity<Iterable<Card>> getSpanishDeck() {
        Homepage homepage = getHomePage();
        return ResponseEntity.ok().body(homepage.getDecks().get(1).getCards());
    }

    @GetMapping("/state-capitals-deck")
    private ResponseEntity<Iterable<Card>> getStateCapitalsDeck() {
        Homepage homepage = getHomePage();
        return ResponseEntity.ok().body(homepage.getDecks().get(2).getCards());
    }

    private Homepage getHomePage() {
        long id = 0L;
        if (!homepageService.existsById(id))
            createHomepage(id);

        Homepage homepage = homepageService.findById(id);
        return homepage;
    }

    // Creates homepage and adds decks to it.
    private Homepage createHomepage(long id) {
        Homepage homepage = new Homepage();
        homepage.setId(id);
        homepage.addDecks(createCoreJavaDeck(), createSpanishDeck(), createStateCapitalsDeck());
        homepageService.save(homepage);
        return homepage;
    }

    private Deck createCoreJavaDeck() {
        Deck deck = new Deck();
        deck.addCards(new Card(deck, "What are the 4 principles of Object Oriented Programming?", "A PIE. Abstraction, Polymorphism, Inheritance, Encapsulation", "orange"));
        deck.addCards(new Card(deck, "Explain abstraction", "Abstraction means using simple things to represent complexity. In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This is important because it lets us avoid repeating the same work multiple times. It handles complexity by hiding unnecessary details from the user", "red"));
        deck.addCards(new Card(deck, "Explain polymorphism", "SAME NAME, MANY FORMS. This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. TWO TYPES: Runtime , Polymorphism handled during runtime: example (Overriding) Static , Polymorphism handled in the compiler: example (Overloading)", "red"));
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
        deck.addCards(new Card(deck, "What is an ArrayStoreException? Is it checked or unchecked?", "Thrown to indicate that an attempt has been made to store the wrong type of object into an array of objects. It is an unchecked error that occurs at runtime"));
        deck.addCards(new Card(deck, "Describe JVM, JDK, and JRE", "JDK: Java development kit is the tool necessary to compile, document and package Java programs. (like SDK) JRE: A subset of the Java Development Kit (JDK) for end-users and developers who want to redistribute the runtime environment alone. The Java runtime environment consists of the Java virtual machine, the Java core classes, and supporting files. JVM: The java virtual machine is a specification that provides run-time environment in which java byte code can be executed."));
        deck.addCards(new Card(deck, "What is a HashMap?", "HashMap is a Map based collection class that is used for storing Key & value pairs, does not sort the stored keys and Values TALK ABOUT BUCKETS AND COLLISION"));
        deck.addCards(new Card(deck, "Why is a HashMap unsorted?", "Two reasons: One, it IS sorted by Java's own internal logic; entries are sorted by hashcode. It is not sorted in any human-readable way Two, HashMaps are SETS of key-value pairs, and sets are (often) unsorted sets of unique values."));
        deck.addCards(new Card(deck, "What is the difference between Comparable and Comparator?", "Comparable: This interface has one method, compareTo(). Class with objects to be sorted must implement this Comparable interface. Comparator: This interface has two methods, equals() and compare(). Class with objects to be sorted do not need to implement this Comparator interface."));
        deck.addCards(new Card(deck, "What is Class Loader?", "Part of JVM which is used to load classes and interfaces."));
        deck.addCards(new Card(deck, "What are the 5 exception keywords? ", "Try, Catch, Finally, Throw, Throws"));
        deck.addCards(new Card(deck, "Difference between throw and throws?", "'Throws' goes in signature: void method() throws Exception {} 'Throw' goes in method body: void method() { throw new Exception; }"));
        deck.addCards(new Card(deck, "Difference between Final, Finally, Finalize?", "Final: Final is a keyword used to apply restrictions on class, method and variable. Final class can't be inherited, final method can't be overridden and final variable value can't be changed. Finally: Finally is a code block used to place important code, it will be executed whether exception is handled or not. Finalize: Finalize is a method used to perform clean up processing just before object is garbage collected"));
        deck.addCards(new Card(deck, "What is Dictionary in Java?", "The Dictionary class is the abstract parent of any class, such as Hashtable , which maps keys to values. Any non- null object can be used as a key and as a value."));
        deck.addCards(new Card(deck, "Which collection is the fastest?", "In case of index value pair- arraylist, value- hashset and key value pair- hashmap"));
        deck.addCards(new Card(deck, "What is an instance variable?", "An attribute, or field of an object."));
        deck.addCards(new Card(deck, "What is the finalize method?", "The method called before garbage collection on any Java object."));
        deck.addCards(new Card(deck, "What is an access modifier?", "A keyword that describes who or what can access or modifiy the state of an object. Examples: public, private, default, protected"));
        deck.addCards(new Card(deck, "What is an abstract class?", "A class that contains one or more abstract methods, and therefore can never be instantiated. Abstract classes are defined so that other classes can extend them and make them concrete by implementing the abstract methods."));
        deck.addCards(new Card(deck, "What is an abstract method?", "A method that has no implementation. ex interface methods are abstract"));
        deck.addCards(new Card(deck, "What is an API?", "Application Programming Interface. The specification of how a programmer writing an application accesses the behavior and state of classes and objects."));
        deck.addCards(new Card(deck, "What is autoboxing?", "Automatic conversion between reference (Wrapper classes) and primitive types. DONE BY COMPILER"));
        deck.addCards(new Card(deck, "what is a class variable?", "A data item associated with a particular class as a whole--not with particular instances of the class. Class variables are defined in class definitions. Also called a static field"));
        deck.addCards(new Card(deck, "What is a class path?", "An environmental variable which tells the Java virtual machine and Java technologybased applications where to find the class libraries, including user-defined class libraries."));
        deck.addCards(new Card(deck, "What does DOM stand for?", "Document object model."));
        deck.addCards(new Card(deck, "What is an enumerated type?", "A type whose legal values consist of a fixed set of constants. An example of this would be an enum."));
        deck.addCards(new Card(deck, "Explaine garbage collection", "The automatic detection and freeing of memory that is no longer in reference. The Java runtime system performs garbage collection so that programmers never explicitly free objects."));
        deck.addCards(new Card(deck, "Explaine what a generic is", "A class, interface, or method that declares one or more type variables. These type variables are known as type parameters. A generic declaration defines a set of parameterized types, one for each possible invocation of the type parameter section. At runtime, all of these parameterized types share the same class, interface, or method."));
        deck.addCards(new Card(deck, "Explain type erasure", "The deletion of peramatized types at runtime."));
        deck.addCards(new Card(deck, "Why use generics?", "(This answer is blank on the excel sheet.)"));
        deck.addCards(new Card(deck, "Explain type erasure?", "The deletion of peramatized types at runtime."));
        deck.addCards(new Card(deck, "Explain JAR (Java Archive)", "(This answer is blank on the excel sheet.)"));
        deck.addCards(new Card(deck, "Why is java considered dynamic?", "platform-independent file format that aggregates many files into one. Multiple applets written in the Java programming language, and their requisite components can be bundled in a JAR file and subsequently downloaded to a browser in a single HTTP transaction."));
        deck.addCards(new Card(deck, "What does it mean to be multithreaded?", "designed to have parts of its code execute concurrently"));
        deck.addCards(new Card(deck, "What does it mean to be protected?", "signifies that the method or variable can only be accessed by elements residing in its class, subclasses, or classes in the same package."));
        deck.addCards(new Card(deck, "What is serialization? ", "Object created from incoming data (JSON, XML, CSV, whatevs)"));
        deck.addCards(new Card(deck, "What is the difference between a queue and a deque?", "A queue is FIFO (first-in-first-out), a deque has options for FIFO or LIFO (last in first out); it's a queue and a stack in one!"));
        deck.addCards(new Card(deck, "What are design patterns?", "Design patterns are solutions to general problems that software developers faced during software development."));
        deck.addCards(new Card(deck, "What are the three basic groups of design patterns?", "Creational, Structural, Behavior"));
        deck.addCards(new Card(deck, "What is a singleton?", "It's a design pattern, that ensures a class has only one instance, and provides a global point of access to it. It uses a private constructor to limit object"));
        deck.addCards(new Card(deck, "What is a decorator pattern?", "Decorator pattern allows a user to add new functionality to an existing object without altering its structure."));
        deck.addCards(new Card(deck, "What is an Observer pattern?", "Defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically."));
        deck.addCards(new Card(deck, "What is a Factory pattern?", "Defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses."));
        deck.addCards(new Card(deck, "What is a Command pattern?", "The Command Pattern encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and support undoable operations."));
        deck.addCards(new Card(deck, "What is an Adapter pattern?", "Converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces."));
        deck.addCards(new Card(deck, "What is a Facade pattern?", "provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher- level interface that makes the subsystem easier to use."));
        deck.addCards(new Card(deck, "What is the difference between Adapter and Facade?", "Adapter links two incompatible interfaces and facade is used when you want an easier or simpler interface to work with."));
        deck.addCards(new Card(deck, "What is template Method pattern?", "Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm’s structure."));
        deck.addCards(new Card(deck, "What is an anonymous inner class?", "It is an inner class without a name and for which only a single object is created. An anonymous inner class can be useful when making an instance of an object with certain “extras” such as overloading methods of a class or interface, without having to actually subclass a class."));
        deck.addCards(new Card(deck, "What is a lambda expression?", "A function that can be created without belonging to any class."));
        deck.addCards(new Card(deck, "What is a method reference? ", "How java handles passing methods as arguments"));
        deck.addCards(new Card(deck, "Explain streams", "Streams process information in parallel - that is, if a stream is parsing a collection, it will do 'work' to the elements the collection at the same time, unlike a loop which works on one element at a time before working on the next one"));
        deck.addCards(new Card(deck, "What is a functional interface?", "Intefaces that contain only one function that is generally a lambda expression"));
        deck.addCards(new Card(deck, "List the functional interfaces and their functional methods. ", "Function, BiFunction, Consumer, BiConsumer, Runnable, Supplier, Predicate"));
        deck.addCards(new Card(deck, "What is the difference between java7 and java8?", "7 introduced diamond brackets. 8 introduced streams and lambdas"));
        deck.addCards(new Card(deck, "What is functional programming ", "Programming that avoids changing state"));
        deck.addCards(new Card(deck, "What are the FIRST principles of TDD?", "Tests should be: Fast - The code seems to be fast because there is nothing complex about its tests. Independent - The test doesn't depend on other tests. Repeatable - The test will get the same result every time. Self-validating - The test can automatically detect if it's passed. Timely - Both the code and the test code are presented here at the same time."));
        deck.addCards(new Card(deck, "What is the difference between composition and inheritance?", "Composition is instantiating a class as a field ('has a' relationship). Inheritance is inheriting all fields and methods from parent class ('is a' relationship)"));
        deck.addCards(new Card(deck, "What is a thread?", "The path followed when executing a program; all programs have at least 1 thread (known as the main thread)"));
        deck.addCards(new Card(deck, "What is an advantage of Java (with its JVM) over other languages that work from the hardware?", "The JVM can be run on any platform, making it dynamic. C++, for instance, runs on the hardware, so it is not dynamic."));
        deck.addCards(new Card(deck, "What does the word static mean?", "In Java, a static member is a member of a class that isn’t associated with an instance of a class. Instead, the member belongs to the class itself. As a result, you can access the static member without first creating a class instance."));
        return deck;
    }

    private Deck createSpanishDeck() {
        Deck deck = new Deck();
        deck.addCards(new Card(deck, "Hola", "Hello"));
        return deck;
    }

    private Deck createStateCapitalsDeck() {
        Deck deck = new Deck();
        deck.addCards(new Card(deck, "Delaware", "Dover"));
        return deck;
    }
}
