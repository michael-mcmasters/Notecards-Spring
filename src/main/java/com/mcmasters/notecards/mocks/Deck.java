package com.mcmasters.notecards.mocks;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Deck")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user;

    @Column(name = "category")
    private String category;

    @OneToMany
    @JoinColumn(name = "deck_id")
    private Set<Card> cards;

    public Deck() {
        this.cards = new HashSet<>();
    }

    public Deck(Set<Card> cards) {
        this.cards = cards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public void addCards(Card... newCards) {
        for (Card newCard : newCards) {
            cards.add(newCard);
        }
    }
}
