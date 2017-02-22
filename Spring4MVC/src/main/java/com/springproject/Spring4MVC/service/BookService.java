package com.springproject.Spring4MVC.service;


import java.util.List;

import com.springproject.Spring4MVC.model.Mybooks;

public interface BookService {
	
    void save(Mybooks mybooks);
    public List<Mybooks> findAll();
    public List<Mybooks> findbyowner(String emailid);
    public void update(Mybooks mybooks);
    public void delete(int bookid);
    public Mybooks getbook(int bookid);
    public List<Mybooks> searchForBook(String searchText) throws Exception;


}
