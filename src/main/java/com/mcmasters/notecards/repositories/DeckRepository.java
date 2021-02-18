package com.mcmasters.notecards.repositories;

import com.mcmasters.notecards.mocks.Deck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {
}
