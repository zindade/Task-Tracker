package com.taskcli.model;

import com.taskcli.domain.Status;
import java.time.LocalDate;

public class Task {

    private int id;
    private String description;
    private Status status;



    public Task(String description) {
        this.description = description;
        this.status = Status.TODO;


    }

    public Task() {}


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
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


}
