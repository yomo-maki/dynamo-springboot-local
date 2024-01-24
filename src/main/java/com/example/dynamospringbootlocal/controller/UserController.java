package com.example.dynamospringbootlocal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynamospringbootlocal.entity.User;
import com.example.dynamospringbootlocal.service.UserService;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/users")
  public ResponseEntity<Iterable<User>> getUser() {
    return ResponseEntity.ok(userService.getUsers());
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<Optional<User>> getUser(@PathVariable String id) {
    return ResponseEntity.ok(userService.getUser(id));
  }

  @PostMapping("/user")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.addUser(user));
  }

}