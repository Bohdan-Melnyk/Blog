package com.softserve.blog.controller;

import com.softserve.blog.dao.UserDAO;
import com.softserve.blog.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

    private final UserDAO userDAO;

    @GetMapping
    public String hello() {
        return "Hello";
    }

    @GetMapping("/test-list")
    public ResponseEntity<List<String>> getTestList() {
        return ResponseEntity.ok().body(List.of("Hello", "world", "Bohdan", "Vadym", "Oleg"));
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser() {
        return ResponseEntity.ok().body(userDAO.getUserById(1l));
    }
}
