package com.example.dynamospringbootlocal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.kms.model.NotFoundException;
import com.example.dynamospringbootlocal.entity.User;
import com.example.dynamospringbootlocal.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public Iterable<User> getUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUser(String id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new NotFoundException("not found");
    }
    return user;
  }

  public User updateUser(User user, String id) {
    boolean exists = userRepository.existsById(id);
    if (!exists) {
      throw new NotFoundException("ID:" + id);
    }
    user.setId(id);
    return userRepository.save(user);
  }

  public void deleteUser(String id) {
    boolean exists = userRepository.existsById(id);
    if (!exists) {
      throw new NotFoundException("ID:" + id);
    }
    userRepository.deleteById(id);
  }

  public User addUser(User user) {
    return userRepository.save(user);
  }

}
