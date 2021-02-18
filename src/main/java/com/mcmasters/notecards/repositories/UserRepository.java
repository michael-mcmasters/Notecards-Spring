package com.mcmasters.notecards.repositories;

import com.mcmasters.notecards.mocks.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
