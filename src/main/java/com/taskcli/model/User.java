package main.java.com.taskcli.model;

public class User {

    private int id;
    private String username;

    public User(int id, String username, String password, String email) {
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


}
