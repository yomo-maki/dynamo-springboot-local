package com.example.dynamospringbootlocal.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.example.dynamospringbootlocal.entity.User;

@EnableScan
public interface UserRepository extends CrudRepository<User, String> {
}
