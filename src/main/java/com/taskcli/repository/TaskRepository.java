package com.taskcli.repository;

import com.taskcli.domain.Status;
import com.taskcli.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task add(Task task);
    boolean delete(int taskId);
    boolean update(int taskId, String args);
    List<Task> findAll(String args);
    Task getTaskById(int taskId);
    Optional<Task> findById(int taskId);

    boolean updateStatus(Task task);
}
