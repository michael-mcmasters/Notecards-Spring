package com.mcmasters.notecards.services;

import com.mcmasters.notecards.mocks.User;
import com.mcmasters.notecards.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getSampleUser() {

        User user = new User("ano", "money99", "brokebois@yahoo.net", null, null);
        userRepository.save(user);
        return user;
    }
}
