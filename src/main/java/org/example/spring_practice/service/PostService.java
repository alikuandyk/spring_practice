package org.example.spring_practice.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_practice.exception.UserNotFoundException;
import org.example.spring_practice.model.Post;
import org.example.spring_practice.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserService userService;
    private final Map<Integer, Post> posts = new HashMap<>();

    public Post create(Post post) {
        User author = userService.findByEmail(post.getAuthor());
        if (author == null) {
            throw new UserNotFoundException("Пользователь " + post.getAuthor() + " не найден");
        }
        posts.put(post.getId(), post);
        return post;
    }

    public List<Post> findAll() {
        return posts.values().stream().toList();
    }

    public Post getById(int postId) {
        return posts.get(postId);
    }
}

