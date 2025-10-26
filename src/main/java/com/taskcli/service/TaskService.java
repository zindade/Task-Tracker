package com.taskcli.service;

import com.taskcli.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task addTask(String description);

    List<Task> listTasks();

    boolean deleteTask(int taskId);

    Optional<Task> getById(int taskId);

    boolean updateStatus(int id, Status newStatus);
    boolean assignUser(int id, User user);
    List<Task> findByStatus(Status status);
    List<Task> findByUser(User user);
}
