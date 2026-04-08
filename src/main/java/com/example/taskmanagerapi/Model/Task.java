package com.example.taskmanagerapi.Model;

import java.time.LocalDateTime;



public class Task {
    private Integer id;
    private String title;
    private String description;
    private boolean completed = false;
    private LocalDateTime createdDate;

    public Task(){

    }

    public Task(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDate = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
