package com.learn.ib.repository;

import com.learn.ib.models.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface UserRepository {
    User createUser(User user);

    User getUser(UUID id);
}
