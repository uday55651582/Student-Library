package com.springproject.Spring4MVC.service;

public interface SecurityService {
	
    String findLoggedInUsername();

    void autologin(String username, String password);
}
