package com.mcmasters.notecards.repositories;

import com.mcmasters.notecards.mocks.Deck;
import org.springframework.data.repository.CrudRepository;

public interface DeckRepository extends CrudRepository<Deck, Long> {
}
