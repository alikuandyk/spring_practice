package org.example.spring_practice.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_practice.model.User;
import org.example.spring_practice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{email}")
    public User getById(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @PutMapping("/users")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}

