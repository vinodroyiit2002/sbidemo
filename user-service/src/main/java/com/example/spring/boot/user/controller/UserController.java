package com.example.spring.boot.user.controller;

import com.example.spring.boot.user.entity.User;
import com.example.spring.boot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserService userservices;

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return this.userservices.getAllUsers();

    }

    @GetMapping("/users/{id}")
    public User UserById(@PathVariable("id")int id)
    {
       return this.userservices.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        User b = this.userservices.addUser(user);
              return b;
    }

    @PutMapping("/users/{userid}")
    public User updateUser(@RequestBody User user,@PathVariable("userId") int id){
        this.userservices.updateUser(user,id);
        return user;
    }




}
