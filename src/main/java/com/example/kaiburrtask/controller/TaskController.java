package com.example.kaiburrtask.controller;

import com.example.kaiburrtask.model.Task;
import com.example.kaiburrtask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false) String id) {
        if (id != null) {
            return service.getById(id)
                    .map(List::of)
                    .orElseThrow(() -> new RuntimeException("Task not found"));
        }
        return service.getAll();
    }

    @PutMapping
    public Task createOrUpdateTask(@RequestBody Task task) {
        return service.save(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        service.delete(id);
        return "Deleted task with id: " + id;
    }

    @GetMapping("/find")
    public List<Task> findByName(@RequestParam String name) {
        List<Task> tasks = service.findByName(name);
        if (tasks.isEmpty()) throw new RuntimeException("No tasks found");
        return tasks;
    }

    @PutMapping("/{id}/execute")
    public Task executeTask(@PathVariable String id) throws Exception {
        return service.executeTask(id);
    }
}
