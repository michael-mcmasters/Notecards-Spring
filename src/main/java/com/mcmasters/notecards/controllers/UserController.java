package com.mcmasters.notecards.controllers;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Deck;
import com.mcmasters.notecards.mocks.User;
import com.mcmasters.notecards.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getsampleuser")
    public ResponseEntity<User> LogIn(String username, String password) {
        return ResponseEntity.ok().body(userService.getSampleUser());
    }

//    @GetMapping("user/{id}/cards")
//    public ResponseEntity<User> getUserCard() {
//
//    }

    @GetMapping("/decks")
    public ResponseEntity<Deck> getUserDecks() {
        return ResponseEntity.ok().body(userService.getUsersDecks());
    }

    @GetMapping("/cards")
    public ResponseEntity<Set<Card>> getUserCard() {
         return ResponseEntity.ok().body(userService.getUsersCards());
    }
}
