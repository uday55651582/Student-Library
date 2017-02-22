package com.springproject.Spring4MVC.service;

import com.springproject.Spring4MVC.model.User;

public interface UserService {
	
    void save(User user);

    User findByUsername(String username);
}
