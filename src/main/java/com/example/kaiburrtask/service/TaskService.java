package com.example.kaiburrtask.service;

import com.example.kaiburrtask.model.Task;
import com.example.kaiburrtask.model.TaskExecution;
import com.example.kaiburrtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Optional<Task> getById(String id) {
        return repo.findById(id);
    }

    public Task save(Task task) {
        if (isUnsafeCommand(task.getCommand())) {
            throw new RuntimeException("Unsafe command detected!");
        }
        return repo.save(task);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public List<Task> findByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public Task executeTask(String id) throws Exception {
        Task task = repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        String command = task.getCommand();

        if (isUnsafeCommand(command)) {
            throw new RuntimeException("Unsafe command detected!");
        }

        Date start = new Date();
        ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        Date end = new Date();

        TaskExecution exec = new TaskExecution(start, end, output.toString());
        task.getTaskExecutions().add(exec);
        return repo.save(task);
    }

    private boolean isUnsafeCommand(String command) {
        String[] blocked = {"rm", "shutdown", "reboot", "kill", "mkfs", "dd", "format"};
        for (String s : blocked) {
            if (command.toLowerCase().contains(s)) return true;
        }
        return false;
    }
}
