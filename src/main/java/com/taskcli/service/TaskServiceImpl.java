package main.java.com.taskcli.service;

import main.java.com.taskcli.model.Task;
import main.java.com.taskcli.repository.TaskRepository;
import main.java.com.taskcli.repository.TaskRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    public TaskServiceImpl() {
        this.repo = new TaskRepositoryImpl(); // por agora criamos aqui direto
    }

    // (versão mais limpa para testes/unit, podias ter este também)
    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
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
