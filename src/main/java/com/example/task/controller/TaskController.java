package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // ✅ GET all or single task by ID
    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false) String id) {
        if (id != null) {
            Optional<Task> task = taskRepository.findById(id);
            return task.map(List::of).orElse(List.of());
        }
        return taskRepository.findAll();
    }

    // ✅ PUT: create or update a task
    @PutMapping
    public Task createOrUpdateTask(@RequestBody Task task) {
        // optional basic validation
        String cmd = task.getCommand().toLowerCase();
        if (cmd.contains("rm ") || cmd.contains("sudo") || cmd.contains("shutdown")) {
            throw new RuntimeException("Unsafe command!");
        }
        return taskRepository.save(task);
    }

    // ✅ DELETE: delete by ID
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        taskRepository.deleteById(id);
        return "Task deleted: " + id;
    }

    // ✅ GET: search tasks by name substring
    @GetMapping("/search")
    public List<Task> searchByName(@RequestParam String name) {
        return taskRepository.findByNameContainingIgnoreCase(name);
    }

    // ✅ PUT: run a task command by ID and add execution result
    @PutMapping("/{id}/execute")
    public Task executeTask(@PathVariable String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        try {
            Process process = new ProcessBuilder("bash", "-c", task.getCommand()).start();
            process.waitFor();

            var output = new String(process.getInputStream().readAllBytes());
            var exec = new com.example.task.model.TaskExecution();
            exec.setStartTime(new java.util.Date());
            exec.setEndTime(new java.util.Date());
            exec.setOutput(output);

            task.getTaskExecutions().add(exec);
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new RuntimeException("Command execution failed: " + e.getMessage());
        }
    }
}

