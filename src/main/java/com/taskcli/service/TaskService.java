package com.taskcli.service;

import com.taskcli.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task addTask(String description);

    List<Task> listTasks();

    boolean deleteTask(int taskId);

    Optional<Task> getById(int taskId);
}
