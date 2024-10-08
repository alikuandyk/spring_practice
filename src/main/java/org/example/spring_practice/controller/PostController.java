package org.example.spring_practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_practice.model.Post;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@Slf4j
public class PostController {
    List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public List<Post> findAll() {
        return posts;
    }

    @GetMapping("/posts/{postId}")
    public Optional<Post> getById(@PathVariable int postId) {
        return posts.stream()
                .filter(x -> x.getId() == postId)
                .findFirst();
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }
}
