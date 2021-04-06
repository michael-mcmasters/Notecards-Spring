package com.mcmasters.notecards.mocks;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Homepage homepage;

    @ManyToOne
    @JsonBackReference
    private User user;

    @Column(name = "category")
    private String category;

    @OneToMany(cascade = {CascadeType.ALL})
    @JsonManagedReference
    @JoinColumn(name = "deck_id")
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCards(Card... newCards) {
        for (Card newCard : newCards) {
            cards.add(newCard);
        }
    }






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Homepage getHomepage() {
        return homepage;
    }

    public void setHomepage(Homepage homepage) {
        this.homepage = homepage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
