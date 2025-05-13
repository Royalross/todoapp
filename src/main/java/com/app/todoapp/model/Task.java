package com.app.todoapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private boolean completed;
    private String description;

    public Task() {}

    public Task(String title, boolean completed, String description) {
        this.title = title;
        this.completed = completed;
        this.description = description;
    }
}
