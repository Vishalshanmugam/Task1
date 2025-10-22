package com.example.task.service;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    // FIX: Changed the method name to reflect the search property 'command'.
    // FIX: Used the 'name' parameter from the method signature.
    public List<Task> findByCommand(String name) {
        return taskRepository.findByCommandContainingIgnoreCase(name);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(String id) {
        taskRepository.deleteById(id);
    }
}
