package com.example.taskmanagerapi.Exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(int id) {
        super("Task not found with ID: " + id);
    }
}
