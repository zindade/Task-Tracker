package main.java.com.taskcli.repository;

import main.java.com.taskcli.model.Task;

import java.io.IOException;
import java.util.Set;

public interface TaskRepository {

    void addTask(Set<Task> tasks) throws  IOException;
    void saveTasks(Set<Task> tasks) throws IOException;
    Set<Task> getTasks() throws IOException;

}
