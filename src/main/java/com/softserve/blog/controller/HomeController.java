package com.softserve.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping("/test-list")
    public ResponseEntity<List<String>> getTestList() {
        return ResponseEntity.ok().body(List.of("Hello", "world", "Bohdan", "Vadym", "Oleg"));
    }
}
