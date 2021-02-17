package com.mcmasters.notecards.repositories;

import com.mcmasters.notecards.mocks.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
