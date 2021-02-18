package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.Homepage;
import com.mcmasters.notecards.repositories.HomepageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomepageServiceImpl implements HomepageService {

    @Autowired
    private HomepageRepository homepageRepository;

    @Override
    public void save(Homepage homepage) {
        homepageRepository.save(homepage);
    }

    @Override
    public Homepage findById(Long id) {
        // if doesn't exist, create.
        Optional<Homepage> optional = homepageRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            System.out.println("Could not find Homepage with this Id.");
            return null;
        }
    }

    @Override
    public boolean existsById(Long id) {
        return homepageRepository.existsById(id);
    }

    @Override
    public Iterable<Homepage> getAllHomepages() {
        return homepageRepository.findAll();
    }
}
