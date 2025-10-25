package com.taskcli.repository;

import com.taskcli.model.Task;
import java.util.*;

public class TaskRepositoryImpl implements TaskRepository {

    private final Map<Integer, Task> tasks = new HashMap<>();
    private int nextId = 1;

    @Override
    public Task add(Task task) {
        int id = nextId++;
        task.setId(id);
        tasks.put(id, task);
        return task;
    }

    @Override
    public boolean delete(int taskId) {
        return tasks.remove(taskId) != null;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Optional<Task> findById(int taskId) {
        return Optional.ofNullable(tasks.get(taskId));
    }
}
