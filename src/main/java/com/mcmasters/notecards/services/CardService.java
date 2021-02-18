package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CardService {

    public void saveCard(Card card);
}
