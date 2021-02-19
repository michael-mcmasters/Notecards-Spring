package com.mcmasters.notecards.mocks;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "backgroundColor")
    private String backgroundColor;

    @Column(name= "frontText", columnDefinition="LONGTEXT")
    private String frontText;

    @Column(name = "backText", columnDefinition="LONGTEXT" )
    private String backText;

    @ManyToOne
    @JsonBackReference
    private Deck deck;

    public Card() {}

    public Card(String frontText, String backText, String backgroundColor, Deck deck) {
        this.frontText = frontText;
        this.backText = backText;
        this.backgroundColor = backgroundColor;
        this.deck = deck;
    }

    public Card(String frontText, String backText, Deck deck) {
        this.frontText = frontText;
        this.backText = backText;
        this.backgroundColor = "green";
        this.deck = deck;
    }






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrontText() {
        return frontText;
    }

    public void setFrontText(String frontText) {
        this.frontText = frontText;
    }

    public String getBackText() {
        return backText;
    }

    public void setBackText(String backText) {
        this.backText = backText;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
