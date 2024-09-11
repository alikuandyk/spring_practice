package org.example.spring_practice.service;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_practice.exception.InvalidEmailException;
import org.example.spring_practice.exception.UserAlreadyExistException;
import org.example.spring_practice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public List<User> findAll() {
        log.debug("пользователи получены");
        return List.copyOf(users.values());
    }

    public void create(User user) {
        validateUserEmail(user);

        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("четотам");
        }

        users.put(user.getEmail(), user);
        log.debug("пользователь сохранен");
    }

    public User update(User user) {
        validateUserEmail(user);

        if (!users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("че то там ");
        }

        users.put(user.getEmail(), user);
        log.debug("пользовтаел обнавлен");
        return user;
    }

    public User findByEmail(String email) {
        log.debug("пользователь получен");
        User user = users.get(email);
        return user;
    }

    private void validateUserEmail(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("четотам");
        }
    }
}


