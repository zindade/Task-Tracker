package com.taskcli.service;

import com.taskcli.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task addTask(String description);

    List<Task> listTasks(String args);

    boolean deleteTask(int taskId);

    boolean updateTask(int taskId, String args);

    Optional<Task> getById(int taskId);

    boolean markUpdate(String s, int taskId);
}
