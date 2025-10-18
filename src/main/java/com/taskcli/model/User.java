package main.java.com.taskcli.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {


    private int id;
    private String username;
    private Task task   ;


    public User(int id, String username, Task task) {
        this.id = id;
        this.username = username;

    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", task=" + task +
                '}';
    }

}
