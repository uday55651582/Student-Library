package com.springproject.Spring4MVC.service;

import com.springproject.Spring4MVC.model.User;
import com.springproject.Spring4MVC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
     @Autowired 
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   //@Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);   
      
    }

   // @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}