package com.learn.ib.repository;

import com.learn.ib.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


// if you don't define name . it will try its best to name it as in camelcase userRepositoryImplOne. there must be a name ti fetch from application container by default.
@Repository("firstImpl_mysql")
public class UserRepositoryImplOne implements  UserRepository {

    private List<User> userDatabase = new ArrayList<>();

    @Override
    public User createUser(User user) {

        User createdUser = new User(user.getName(), user.getGender());

        userDatabase.add(createdUser);

        return  createdUser;
    }

    @Override
    public User getUser(UUID id) {

       Optional<User> user = userDatabase.stream().filter(x -> x.getUuid().equals(id)).findFirst();

        return user.get();
    }
}
