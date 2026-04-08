package com.example.taskmanagerapi.Controller;

import com.example.taskmanagerapi.Exception.TaskNotFoundException;
import com.example.taskmanagerapi.Model.Task;
import com.example.taskmanagerapi.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController (TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Task>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getAllTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskByID(@PathVariable Integer id){
        Task task = taskService.getTaskByID(id);
        return ResponseEntity.ok().body(task);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task created = taskService.addTask(task.getTitle(),task.getDescription());
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task task) {
        Task updated = taskService.updateTask(id, task);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id){
        taskService.removeTaskByID(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleTaskNotFound(TaskNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleRuntimeException(RuntimeException ex) {
        return Map.of("error", ex.getMessage());
    }
}
