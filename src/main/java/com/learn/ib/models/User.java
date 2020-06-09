package com.learn.ib.models;

import com.learn.ib.utils.Constants;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {

    private UUID  uuid;
    private String name;
    private Constants.Gender gender;

    public User(String name, Constants.Gender gender){

        this.uuid = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
    }
}
