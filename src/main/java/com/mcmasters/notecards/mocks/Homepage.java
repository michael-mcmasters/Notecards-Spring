package com.mcmasters.notecards.mocks;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "homepage")
public class Homepage {

    @Id
    private Long id;

    @Column(name = "testName")
    private String testName;

    @OneToMany (cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Set<Deck> decks;

    public Homepage() {
        decks = new HashSet<Deck>();
    }

    public Homepage(Long id, Set<Deck> decks) {
        this.id = id;
        this.decks = decks;
    }

    public void addDecks(Deck... newDecks) {
        for (Deck newDeck : newDecks) {
            decks.add(newDeck);
        }
    }






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Set<Deck> getDecks() {
        return decks;
    }

    public void setDecks(Set<Deck> decks) {
        this.decks = decks;
    }
}
