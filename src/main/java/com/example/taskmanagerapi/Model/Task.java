package com.example.taskmanagerapi.Model;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed = false;
    private LocalDateTime createdDate;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
