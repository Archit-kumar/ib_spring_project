package com.learn.ib.controller;

import com.learn.ib.dto.ResponseDTO;
import com.learn.ib.models.User;
import com.learn.ib.services.UserService;
import com.learn.ib.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(Constants.USERS_END_POINT)
public class  UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){

        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseDTO<User> getUser(@PathVariable("id") UUID id){

        User user = userService.getUser(id);

        if(user == null){
            return new ResponseDTO(HttpStatus.NOT_FOUND, user);
        }

        return new ResponseDTO(HttpStatus.FOUND,user);
    }

}
