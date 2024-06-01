package com.example.taskmanager.tm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskServ taskServ;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskServ.getAllTasks();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") int taskId) {
        Task task = taskServ.getTaskById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
        return ResponseEntity.ok().body(task);
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskServ.saveOrUpdateTask(task);
        return ResponseEntity.ok().body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(value = "id") int taskId, @RequestBody Task taskDetails) {
        Task task = taskServ.getTaskById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
        task.setTitle(taskDetails.getTitle());
        task.setDetails(taskDetails.getDetails());
        task.setStatus(taskDetails.getStatus());
        Task updatedTask = taskServ.saveOrUpdateTask(task);
        return ResponseEntity.ok().body(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(value = "id") int taskId) {
        taskServ.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}

