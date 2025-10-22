package com.example.task.controller;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public Task runCommand(@RequestBody Task request) {
        String command = request.getCommand();
        StringBuilder output = new StringBuilder();
        Task task = new Task();
        task.setCommand(command);

        try {
            Process process = new ProcessBuilder("bash", "-c", command).start();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            int exitCode = process.waitFor();
            task.setOutput(output.toString());
            task.setStatus(exitCode == 0 ? "SUCCESS" : "FAILED");
        } catch (Exception e) {
            task.setOutput(e.getMessage());
            task.setStatus("FAILED");
        }

        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
