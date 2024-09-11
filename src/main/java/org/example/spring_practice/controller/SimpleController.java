package org.example.spring_practice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SimpleController {
    @GetMapping("/home")
    public String helloPage() {
        return "Котограм";
    }
}
