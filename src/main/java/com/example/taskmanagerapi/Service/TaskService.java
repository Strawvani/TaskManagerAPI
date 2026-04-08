package com.example.taskmanagerapi.Service;

import com.example.taskmanagerapi.Exception.TaskNotFoundException;
import com.example.taskmanagerapi.Model.Task;
import com.example.taskmanagerapi.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public ArrayList<Task> getAllTask(){
        ArrayList<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()){
            throw new RuntimeException("No Tasks Found");
        }
        return tasks;
    }

    public Task getTaskByID(int id){
        if (id <= 0){
            throw new RuntimeException("ID must be a positive number");
        }
        Task task = taskRepository.findByID(id);
        if (task == null){
            throw new TaskNotFoundException(id);
        }
        return task;
    }

    public String addTask(Task task){
        taskRepository.save(task);
        return task.getTitle() + " was Successfully Added to the Tasklist!";
    }

    public boolean removeTaskByID(int id){
        if (taskRepository.findByID(id) == null){
            throw new TaskNotFoundException(id);
        }
        return taskRepository.deleteByID(id);
    }
}
