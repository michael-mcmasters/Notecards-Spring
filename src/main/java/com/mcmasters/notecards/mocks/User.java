package com.mcmasters.notecards.mocks;

import javax.persistence.*;
import java.util.ArrayList;
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
    private ArrayList<Deck> decks;

    @Column(name = "badges")
    private ArrayList<String> badges;

    @Column(name = "loggedOn")
    private boolean loggedOn = false;


    public User() {}

    public User(String userName, String encryptedPswd, String email, ArrayList<Deck> decks, ArrayList<String> badges) {
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

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public ArrayList<String> getBadges() {
        return badges;
    }

    public void setBadges(ArrayList<String> badges) {
        this.badges = badges;
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(boolean loggedOn) {
        this.loggedOn = loggedOn;
    }
}
