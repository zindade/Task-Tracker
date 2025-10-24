package com.taskcli.cli;


import com.taskcli.model.Task;
import com.taskcli.service.TaskService;
import com.taskcli.service.TaskServiceImpl;

package com.taskcli.cli;

import com.taskcli.model.Task;
import com.taskcli.service.TaskService;
import com.taskcli.service.TaskServiceImpl;

public class Task {



     private int id;
    private String description;
    private Status status;
     private LocalDate createdAt ;
     private LocalDate updatedAt;
     private User assignee;



    public Task(String description) {
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.assignee = null;
    }

     public Task(int id, String description, Status status, LocalDate createdAt, LocalDate updatedAt, User assignee){

         this.id = id;
         this.status = status;
         this.description = description;
         this.createdAt= createdAt;
         this.updatedAt = updatedAt;
         this.assignee = assignee;
     }
    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
