package com.springproject.Spring4MVC.repository;

import com.springproject.Spring4MVC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}