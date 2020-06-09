package com.learn.ib.services;

import com.learn.ib.models.User;
import com.learn.ib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    UserService( @Qualifier("secondImpl_postgres") UserRepository userRepository){

        // hard coded approach to call specified implementation. either it can be firstImpl_mysql or secondImpl_postgres

        // another approach is you can configure this in application.properties
        this.userRepository = userRepository;
    }

    public User createUser(User user){

        return userRepository.createUser(user);
    }

    public User getUser(UUID id) {
        return userRepository.getUser(id);
    }
}
