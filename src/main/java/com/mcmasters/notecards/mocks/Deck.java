package com.mcmasters.notecards.mocks;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("decks")
    private User user;

    @Column(name = "category")
    private String category;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "deck_id")
    @JsonBackReference
    private Set<Card> cards;

    public Deck() {
        this.cards = new HashSet<>();
    }

    public Deck(Set<Card> cards) {
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
