package com.example.taskmanagerapi.Repository;

import com.example.taskmanagerapi.Model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;


@Repository
public class TaskRepository {

    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;

    public ArrayList<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Task findByID (int id){
        return tasks.get(id);
    }

    public Task save(Task task) {
        if (task.getId() == 0) {
            task.setId(nextId++);
        }
        tasks.put(task.getId(), task);
        return task;
    }

    public boolean deleteByID (int id){
        return tasks.remove(id) != null;
    }
}
