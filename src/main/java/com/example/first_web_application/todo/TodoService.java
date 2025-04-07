package com.example.first_web_application.todo;


import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "Hemanth Paluri", "Learning Spring Boot", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "Hemu", "Learning DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "Hemanth Paluri", "Learning AWS", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username){
        return todos.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean completed){
        Todo todo = new Todo(++todoCount, username, description, targetDate, completed);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        todos.removeIf(predicate);
    }
    public Todo findById(int id) {
        //Predicate<? super Todo> predicate = todo -> todo.getId()==id;
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst().get();
    }

    public void updateTodo(@Valid Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }

}
