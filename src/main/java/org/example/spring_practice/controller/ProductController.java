package org.example.spring_practice.controller;

import org.example.spring_practice.model.Post;
import org.example.spring_practice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    List<Product> products = List.of(
            new Product("Яблоко", 750),
            new Product("Бананы", 1200),
            new Product("Апельсины", 900),
            new Product("Винограды", 1500),
            new Product("Абрикос", 700),
            new Product("Клубника", 3_000)
    );

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(required = false) Integer from, @RequestParam(required = false) Integer to) {
        return products.stream()
                .filter(product -> {
                    boolean isFrom = (from == null) || (product.price() >= from);
                    boolean isTo = (to == null) || (product.price() <= to);
                    return isFrom && isTo;
                })
                .toList();
    }
}
