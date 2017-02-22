package com.springproject.Spring4MVC.repository;

import com.springproject.Spring4MVC.model.Mybooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Mybooks, Long> {
}