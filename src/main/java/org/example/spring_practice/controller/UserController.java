package org.example.spring_practice.controller;

import org.example.spring_practice.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    List<User> users = new ArrayList<>();

    @GetMapping("/home")
    public String helloPage() {
        return "Котограм";
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return users;
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @PutMapping("/users")
    public User update(@RequestBody User user) {
        return user;
    }
}
