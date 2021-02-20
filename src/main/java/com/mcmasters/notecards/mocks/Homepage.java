package com.mcmasters.notecards.mocks;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "homepagee")
public class Homepage {

    @Id
    private Long id;

    @Column(name = "testName")
    private String testName;

    @OneToMany (cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<Deck> decks;

    public Homepage() {
        decks = new ArrayList<Deck>();
    }

    public Homepage(Long id, ArrayList<Deck> decks) {
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

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }
}
