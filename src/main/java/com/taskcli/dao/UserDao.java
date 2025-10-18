package main.java.com.taskcli.dao;

import main.java.com.taskcli.model.Task;
import main.java.com.taskcli.model.User;

import java.util.List;

public interface UserDao {

    User insert(User id);
    List<User> getAllTasks();
    void addTask(User user);
    void updateTask(User user);
    void deleteTask(int id);
    User findById(Integer id);
}

