package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Card;
import com.mcmasters.notecards.mocks.Homepage;
import org.springframework.stereotype.Service;

@Service
public interface HomepageService {

    public void save(Homepage homepage);

    public Homepage findById(Long id);

    public boolean existsById(Long id);

    public Iterable<Homepage> getAllHomepages();
}
