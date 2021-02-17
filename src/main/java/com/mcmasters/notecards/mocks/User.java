package com.mcmasters.notecards.mocks;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "deck")
    private List<Deck> decks;

    @Column(name = "badges")
    private List<String> badges;


    public User() {}

    public User(String userName, String encryptedPswd, String email, List<Deck> decks, List<String> badges) {
        this(1L, userName, encryptedPswd, email, decks, badges);
    }

    public User(long id, String userName, String encryptedPswd, String email, List<Deck> decks, List<String> badges) {
        this.id = id;
        this.userName = userName;
        this.encryptedPswd = encryptedPswd;
        this.email = email;
        this.decks = decks;
        this.badges = badges;
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

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public List<String> getBadges() {
        return badges;
    }

    public void setBadges(List<String> badges) {
        this.badges = badges;
    }
}
