package main.java.com.taskcli.dao;

import main.java.com.taskcli.model.Task;
import java.util.List;

public interface TASKDAO {

    Task getTaskById(int id);
    List<Task> getAllTasks();
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(int id);
}
