package com.learn.ib.repository;

import com.learn.ib.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("secondImpl_postgres")
public class UserRepositoryImplTwo implements  UserRepository {

    private List<User> userDatabase = new ArrayList<>();

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String password;

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
