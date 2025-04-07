package com.example.first_web_application.todo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Entity
@Table(name = "tododb")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-GENERATION STRATEGY
    private int id;

    @Column(name = "name")
    private String username;
    @Size(min = 10, message = "Should Contain minimum 10 characters")
    private String description;
    private boolean completed;

    @Column(name = "target_date")
    private LocalDate targetDate;

    // Getters and Setters



    public Todo(int id, String username, String description, LocalDate targetDate, boolean completed){
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.completed = completed;
    }

    public Todo() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString(){
        return "Todo [id = "+id+", username = "+username+", description = "+description+", targetDate = "+targetDate+", completed = "+completed+"]";
    }

}
