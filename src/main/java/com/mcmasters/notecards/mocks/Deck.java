package com.mcmasters.notecards.mocks;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Deck")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    @JoinColumn(name = "deck_id")
    private Set<Card> cards;

    public Deck() {}

    public Deck(Set<Card> cards) {
        this.cards = cards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
