package com.example.first_web_application.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    //public List<Todo> finByUsername(String username);

    List<Todo> findByUsername(String username);
}
