package main.java.com.taskcli.dao;

import main.java.com.taskcli.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User insert(User id) {
        return null;
    }

    @Override
    public List<User> getAllTasks() {
        return List.of();
    }

    @Override
    public void addTask(User user) {

    }

    @Override
    public void updateTask(User user) {

    }

    @Override
    public void deleteTask(int id) {

    }

    @Override
    public void findById(int id) {
        return  ;
    }
}
