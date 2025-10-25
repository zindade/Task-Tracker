package com.taskcli.model;

import com.taskcli.domain.Status;
import java.time.LocalDate;

public class Task {

    private int id;
    private String description;
    private Status status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private User assignee;


    public Task(String description) {
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.assignee = null;
    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public User getAssignee() {
        return assignee;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
}
