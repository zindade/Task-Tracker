package com.taskcli.service;

import com.taskcli.model.Task;
import com.taskcli.repository.TaskRepository;
import com.taskcli.repository.TaskRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    public TaskServiceImpl() {
        this.repo = new TaskRepositoryImpl();
    }

    @Override
    public Task addTask(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description cannot be empty");
        }
        Task t = new Task(description);
        return repo.add(t);
    }

    @Override
    public List<Task> listTasks() {
        return repo.findAll();
    }

    @Override
    public boolean deleteTask(int taskId) {
        return repo.delete(taskId);
    }

    @Override
    public Optional<Task> getById(int taskId) {
        return repo.findById(taskId);
    }
}
