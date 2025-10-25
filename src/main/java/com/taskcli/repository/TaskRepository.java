package com.taskcli.repository;

import com.taskcli.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task add(Task task);
    boolean delete(int taskId);
    List<Task> findAll();
    Optional<Task> findById(int taskId);
}
