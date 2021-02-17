package com.mcmasters.notecards.mocks;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String encryptedPswd;

    @Column(name = "email")
    private String email;

    @OneToMany
    @JoinColumn(name = "deck_id")
    private Set<Deck> decks;

    @Column(name = "badge")
    //private Set<String> badges;
    private String badge;

    @Column(name = "loggedOn")
    private boolean loggedOn = false;


    public User() {
        decks = new HashSet<>();
    }

    public User(String userName, String encryptedPswd, String email, Set<Deck> decks, String badge) {
        this.userName = userName;
        this.encryptedPswd = encryptedPswd;
        this.email = email;
        this.decks = decks;
        this.badge = badge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPswd() {
        return encryptedPswd;
    }

    public void setEncryptedPswd(String encryptedPswd) {
        this.encryptedPswd = encryptedPswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Deck> getDecks() {
        return decks;
    }

    public void setDecks(Set<Deck> decks) {
        this.decks = decks;
    }

    public void addDeck(Deck... newDecks) {
//        Collections.addAll(decks, newDecks);
        for (Deck d : newDecks) {
            decks.add(d);
        }
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(boolean loggedOn) {
        this.loggedOn = loggedOn;
    }
}
