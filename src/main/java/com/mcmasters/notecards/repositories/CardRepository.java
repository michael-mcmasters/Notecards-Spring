package com.mcmasters.notecards.repositories;

import com.mcmasters.notecards.mocks.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
}
