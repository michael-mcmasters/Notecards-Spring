package com.mcmasters.notecards.repositories;

import com.mcmasters.notecards.mocks.Homepage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomepageRepository extends CrudRepository<Homepage, Long> {
}
